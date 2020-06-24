package com.example.shell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.shell.SpringShellAutoConfiguration;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.shell.standard.StandardAPIAutoConfiguration;
import org.springframework.shell.standard.commands.StandardCommandsAutoConfiguration;

@Configuration
@Import({
		// Core runtime
		SpringShellAutoConfiguration.class,
		StandardAPIAutoConfiguration.class,
		// Built-In Commands
		StandardCommandsAutoConfiguration.class,
		MyCommand.class,
})
@SpringBootApplication
public class SpringShellSample {

	public static void main(String[] args) {
		SpringApplication.run(SpringShellSample.class, args);
	}

	@Bean
	public PromptProvider myPromptProvider() {
		return () -> new AttributedString("my-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
	}

}
