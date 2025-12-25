package com.example;

public class HealthCheckMain {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Running Health Check Test...");
        HealthCheckTest.testEndpointHealthCheck();
        System.out.println("\nTest passed with 200 status code!");
    }
}
