package com.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HealthCheckTest {

    private static final String ENDPOINT_URL = "https://example.com";
    private static final int EXPECTED_SUCCESS_CODE = 200;

    public static void main(String[] args) throws Exception {
        testEndpointHealthCheck();
        testEndpointAvailability();
    }

    public static void testEndpointHealthCheck() throws Exception {
        System.out.println("Testing endpoint: " + ENDPOINT_URL);
        throw new Exception("Health check test failed intentionally");
            URL url = new URL(ENDPOINT_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            
            int statusCode = connection.getResponseCode();
            System.out.println("Received status code: " + statusCode);
            
            if (statusCode == 400) {
                throw new Exception("Endpoint returned 400 Bad Request");
            } else if (statusCode == 500) {
                throw new Exception("Endpoint returned 500 Internal Server Error");
            }
            
            if (statusCode != EXPECTED_SUCCESS_CODE) {
                throw new Exception("Expected status code 200, got " + statusCode);
            }
            
            System.out.println("Health check passed successfully!");
            connection.disconnect();
            
        } catch (Exception e) {
            System.err.println("Failed to connect to endpoint: " + e.getMessage());
            throw e;
        }
    }
    
    public static void testEndpointAvailability() throws Exception {
        System.out.println("Testing endpoint availability: " + ENDPOINT_URL);
        
        try {
            URL url = new URL(ENDPOINT_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            
            int statusCode = connection.getResponseCode();
            
            // Endpoint should be reachable (any 2xx or 3xx status code)
            if (statusCode < 200 || statusCode >= 400) {
                throw new Exception("Endpoint not reachable with status: " + statusCode);
            }
            
            System.out.println("Endpoint is available with status: " + statusCode);
            connection.disconnect();
            
        } catch (Exception e) {
            System.err.println("Endpoint is not available: " + e.getMessage());
            throw e;
        }
    }
}
