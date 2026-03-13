package org.example.servers;

import jakarta.xml.ws.Endpoint;

public class MathServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/mathService";
        Endpoint.publish(url, new org.example.services.MathServiceImpl());
        System.out.println("SOAP server started at " + url);
        System.out.println("WSDL is available at " + url + "?wsdl");
    }
}
