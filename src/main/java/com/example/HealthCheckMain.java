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
        
            System.out.println("Running Health Check via test class...");
            HealthCheckTest.runHealthCheck();
            System.out.println("\nMain: Health check returned 200.");
        }
    }
