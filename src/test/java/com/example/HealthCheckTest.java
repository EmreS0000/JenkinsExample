package com.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HealthCheckTest {
    private static final String ENDPOINT_URL = "https://example.com";

    public static void runHealthCheck() throws Exception {
        System.out.println("Testing endpoint: " + ENDPOINT_URL);
        URL url = new URL(ENDPOINT_URL);
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
    }

    public static void main(String[] args) throws Exception {
        runHealthCheck();
        System.out.println("Main branch: test finished with 200");
    }
}
