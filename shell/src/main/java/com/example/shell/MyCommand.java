package com.example.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent()
public class MyCommand {

    @ShellMethod(value = "Echo input, parameter without --: echo stuff hallo", prefix = "")
    public String echo(String stuff) {
        return stuff;
    }

    @ShellMethod(value = "Echo input, default form: echo-default --stuff hallo.")
    public String echoDefault(String stuff) {
        return stuff;
    }
}
