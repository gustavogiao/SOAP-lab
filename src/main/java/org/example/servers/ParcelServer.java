package org.example.servers;

import jakarta.xml.ws.Endpoint;
import org.example.services.ParcelServiceImpl;

public class ParcelServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/parcelService";
        Endpoint.publish(url, new ParcelServiceImpl());
        System.out.println("SOAP Server started at " + url);
        System.out.println("WSDL available at " + url + "?wsdl");
    }
}
