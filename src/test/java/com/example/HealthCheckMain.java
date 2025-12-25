package com.example;

public class HealthCheckMain {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Running Health Check Test...");
        HealthCheckTest.testEndpointHealthCheck();
        System.out.println("\nTest passed with 200 status code!");
        
        // Simulating 400 error
        System.out.println("\n--- Now simulating 400 error ---");
        throw new Exception("Endpoint returned 400 Bad Request");
    }
}
