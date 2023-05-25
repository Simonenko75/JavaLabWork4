package com.example.LabWork4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/execute")
    public @ResponseBody Response execute(@RequestParam Type type) throws SQLException {
        return testService.execute(type);
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public @ResponseBody Response uncheckedError() {
        return new Response("Unknown error, please connect to support...");
    }

    @ExceptionHandler({SQLException.class})
    public @ResponseBody Response sqlError() {
        return new Response("Database is down, please check it before try again...");
    }

}
