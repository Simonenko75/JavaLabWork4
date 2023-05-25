package com.example.LabWork4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequestMapping("/test/another")
public class AnotherController {

    @Autowired
    private TestService testService;

    @GetMapping("/execute")
    public @ResponseBody Response execute(@RequestParam Type type) throws SQLException {
        return testService.execute(type);
    }

}
