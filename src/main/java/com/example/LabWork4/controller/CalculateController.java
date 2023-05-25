package com.example.LabWork4.controller;

import com.example.LabWork4.model.CalculateRequestDTO;
import com.example.LabWork4.model.CalculateResponseDTO;
import com.example.LabWork4.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping("/sum")
    public @ResponseBody CalculateResponseDTO sum(@RequestBody CalculateRequestDTO calculateRequestDTO) {
        return calculateService.sum(calculateRequestDTO);
    }

}
