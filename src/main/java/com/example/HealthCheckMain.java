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
        
        int statusCode = connection.getResponseCode();
        System.out.println("Received status code: " + statusCode);
        
        if (statusCode != 200) {
            throw new Exception("Expected 200, got " + statusCode);
        }
        
        System.out.println("Health check passed!");
        connection.disconnect();
