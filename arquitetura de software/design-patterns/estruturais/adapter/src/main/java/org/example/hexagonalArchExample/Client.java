package org.example.hexagonalArchExample;

import org.example.hexagonalArchExample.application.UserRest;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        var userRest = new UserRest();
        var requestBody = new HashMap<String, String>();
        requestBody.put("name", "Joaozinho");
        requestBody.put("email", "joaozinho@email.com");

        var statusCode = userRest.post(requestBody);
        System.out.println("Status code from POST: "+ statusCode);

        statusCode = userRest.getAll();
        System.out.println("Status code from GET: "+ statusCode);
    }
}
