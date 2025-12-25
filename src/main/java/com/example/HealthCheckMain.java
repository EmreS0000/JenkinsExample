package com.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HealthCheckMain {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Running Health Check...");
        
        String endpoint = "https://example.com";
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        
        // Simulating 400 error for test branch
        System.out.println("Simulating 400 Bad Request...");
        throw new Exception("Endpoint returned 400 Bad Request");
    }
}
