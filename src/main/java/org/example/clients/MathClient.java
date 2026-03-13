package org.example.clients;

import jakarta.xml.ws.Service;
import org.example.services.MathService;

import javax.xml.namespace.QName;
import java.net.URL;

public class MathClient {
    public static void main(String[] args) throws Exception {
        URL wsdl = new URL("http://localhost:8080/mathService?wsdl");
        QName qname = new QName(
                "http://services.example.org/",
                "MathServiceImplService"
        );
        Service service = Service.create(wsdl, qname);
        MathService port = service.getPort(MathService.class);

        System.out.println("Fatorial de 5: " + port.factorial(5));
        System.out.println("Maior primo entre 10 e 20: " + port.maxPrime(10, 20));
        System.out.println("Menor primo entre 10 e 20: " + port.minPrime(10, 20));
        System.out.println("Soma de 10, 20 e 30: " + port.sum(new int[]{10, 20, 30}));
    }
}
