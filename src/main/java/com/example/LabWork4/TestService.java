package com.example.LabWork4;

import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TestService {

    public Response execute(Type type) throws SQLException {
        if (Type.NullPointer.equals(type)) {
            throw new NullPointerException();
        } else if (Type.Illegal.equals(type)) {
            throw new IllegalArgumentException();
        } else if (Type.SQL.equals(type)) {
            throw new SQLException();
        }

        return new Response(Type.OK.name());
    }

}
