package com.example.LabWork4;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public @ResponseBody Response uncheckedError() {
        return new Response("Unknown error, please connect to support...");
    }

    @ExceptionHandler({SQLException.class})
    public @ResponseBody Response sqlError() {
        return new Response("Database is down, please check it before try again...");
    }

    @ExceptionHandler({MyException.class})
    public @ResponseBody Response myExceptionError() {
        return new Response("My exception is work, don't touch it :)...");
    }

    @ExceptionHandler({Exception.class})
    public @ResponseBody Response anyAnotherError() {
        return new Response("Some problem... Sorry.");
    }

}
