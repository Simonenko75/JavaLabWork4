package com.example.LabWork4.service;

import com.example.LabWork4.model.CalculateRequestDTO;
import com.example.LabWork4.model.CalculateResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    public CalculateResponseDTO sum(CalculateRequestDTO calculateRequestDTO) {
        int result = calculateRequestDTO.getFirstValue() + calculateRequestDTO.getSecondValue();
        CalculateResponseDTO calculateResponseDTO = new CalculateResponseDTO();
        calculateResponseDTO.setResult(result);
        return calculateResponseDTO;
    }

}
