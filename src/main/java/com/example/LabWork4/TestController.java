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

    @GetMapping("/execute/string")
    public @ResponseBody ResponseMessage executeString(@RequestParam Type type) {
        if (!Type.OK.equals(type)) {
            throw new RuntimeException("AAA!!!");
        }

        return new ResponseMessage("Hello!");
    }

}
