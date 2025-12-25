package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;

public class HealthCheckTest {
    private static final String ENDPOINT_URL = System.getProperty("endpointUrl", "https://example.com");
    private static final int EXPECTED_STATUS = Integer.getInteger("expectedStatus", 200);

    @Test
    public void healthCheckReturnsExpectedStatus() throws Exception {
        URL url = new URL(ENDPOINT_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        int statusCode = connection.getResponseCode();
        connection.disconnect();
        assertEquals("Expected " + EXPECTED_STATUS + " from " + ENDPOINT_URL, EXPECTED_STATUS, statusCode);
    }
}
