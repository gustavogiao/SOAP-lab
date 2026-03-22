package org.example.servers;

import jakarta.xml.ws.Endpoint;
import org.example.services.ReservationServiceImpl;

public class ReservationServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/reservationService";
        Endpoint.publish(url, new ReservationServiceImpl());
        System.out.println("SOAP Server started at " + url);
        System.out.println("WSDL available at " + url + "?wsdl");
    }
}
