package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ch.qos.logback.classic.util.ClassicEnvUtil;

@RestController
public class UrlCheckController {
 private final String upSite = "Up Site";
 private final String downSite = "Down Site";
 private final String IncorrectURL = "Url is incorrect";
    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String returnMessage = "";
        try{    
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)urlObj.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCodeCategory = conn.getResponseCode() / 100;
        if(responseCodeCategory != 2 || responseCodeCategory != 3){
            returnMessage = downSite;
        }
        else{
            returnMessage = upSite;
        }
        } catch (MalformedURLException e) {
            returnMessage = IncorrectURL;
        } catch (IOException e) {
            returnMessage = downSite;
        }
        return returnMessage;     
    }
    
}
