package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

public class portController {
  @Autowired
    private WebServerApplicationContext context;

    @GetMapping("/port")
    public String getPort() {
        return "Running on port: " + context.getWebServer().getPort();
    }
}
