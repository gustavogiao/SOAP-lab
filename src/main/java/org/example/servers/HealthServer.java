package org.example.servers;

import jakarta.xml.ws.Endpoint;
import org.example.services.HealthServiceImpl;

public class HealthServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/healthService";
        Endpoint.publish(url, new HealthServiceImpl());
        System.out.println("HealthService is running at " + url);
        System.out.println("WSDL is available at " + url + "?wsdl");
    }
}
