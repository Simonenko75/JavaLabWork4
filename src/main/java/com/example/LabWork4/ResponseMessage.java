package com.example.LabWork4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {

    public String value;

    public ResponseMessage(String value) {
        this.value = value;
    }

}
