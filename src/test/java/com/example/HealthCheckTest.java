package com.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HealthCheckTest {
    private static final String ENDPOINT_URL = "https://example.com";

    public static void runHealthCheck() throws Exception {
        throw new Exception("Endpoint returned 400 Bad Request (test branch)");
    }

    public static void main(String[] args) throws Exception {
        // Simulate 400 on test branch; Jenkins won't run here due to branch gating
        runHealthCheck();
    }
}
