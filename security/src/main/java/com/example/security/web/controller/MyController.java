package com.example.security.web.controller;

import com.example.security.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@Configuration
@EnableWebSecurity
public class MyController extends WebSecurityConfigurerAdapter {

    Map<Integer, Stuff> myStuff = new HashMap<>();

    public MyController() {
        myStuff.put(1, new Stuff(1, "one", "me"));
        myStuff.put(2, new Stuff(2, "two", "me"));
        myStuff.put(3, new Stuff(3, "three", "theOtherGuy"));
    }

    @GetMapping("/")
    public String get() {
        return "OK";
    }

    @GetMapping("/stuff/{myId}")
    public Stuff getById(@PathVariable final Integer myId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Stuff stuff = myStuff.get(myId);
        if (stuff == null) {
            throw new IllegalArgumentException(String.format("Stuff with id %s not found", myId));
        }
        if (stuff.getOwner().equals(auth.getName())) {
            return stuff;
        } else {
            throw new IllegalArgumentException(String.format("Stuff with id %s not found", myId));
        }
    }

    @GetMapping("/stuff/all")
    public Stream<Stuff> getAllStuff() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return myStuff.values().stream().filter(s -> s.getOwner().equals(auth.getName()));
    }

    @PostMapping("/stuff")
    public Stuff add(@RequestBody Stuff stuff) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        stuff.updateHash();
        stuff.setOwner(auth.getName());
        myStuff.put(stuff.getId(), stuff);
        return stuff;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails me =
                User.builder()
                        .username("me")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build();
        UserDetails theOtherGuy =
                User.builder()
                        .username("theOtherGuy")
                        .password("password")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(me, theOtherGuy);
    }
}
