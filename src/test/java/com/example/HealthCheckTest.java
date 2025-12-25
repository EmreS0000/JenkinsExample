package com.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import static org.junit.Assert.*;

public class HealthCheckTest {

    private static final String ENDPOINT_URL = "https://example.com";
    private static final int EXPECTED_SUCCESS_CODE = 200;
    private static final int TIMEOUT_SECONDS = 30;

    @Test
    public void testEndpointHealthCheck() throws Exception {
        System.out.println("Testing endpoint: " + ENDPOINT_URL);
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(ENDPOINT_URL);
        
        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            
            System.out.println("Received status code: " + statusCode);
            
            if (statusCode == 400) {
                fail("Endpoint returned 400 Bad Request");
            } else if (statusCode == 500) {
                fail("Endpoint returned 500 Internal Server Error");
            }
            
            assertEquals("Expected status code 200", EXPECTED_SUCCESS_CODE, statusCode);
            
            System.out.println("Health check passed successfully!");
            
        } catch (Exception e) {
            System.err.println("Failed to connect to endpoint: " + e.getMessage());
            fail("Unable to reach endpoint: " + e.getMessage());
        } finally {
            httpClient.close();
        }
    }
    
    @Test
    public void testEndpointAvailability() throws Exception {
        System.out.println("Testing endpoint availability: " + ENDPOINT_URL);
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(ENDPOINT_URL);
        
        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            
            // Endpoint should be reachable (any 2xx or 3xx status code)
            assertTrue("Endpoint should be reachable", 
                      statusCode >= 200 && statusCode < 400);
            
            System.out.println("Endpoint is available with status: " + statusCode);
            
        } catch (Exception e) {
            fail("Endpoint is not available: " + e.getMessage());
        } finally {
            httpClient.close();
        }
    }
}
