package org.example.clients;

import jakarta.xml.ws.Service;
import org.example.services.HealthService;

import javax.xml.namespace.QName;
import java.net.URL;

public class HealthClient {
    public static void main(String[] args) throws Exception {
        URL wsdl = new URL("http://localhost:8080/healthService?wsdl");

        QName qName = new QName(
                "http://services.example.org/",
                "HealthServiceImplService"
        );

        Service service = Service.create(wsdl, qName);
        HealthService port = service.getPort(HealthService.class);

        double bmi = port.bmi(70, 1.75);
        System.out.println("Indice de massa corporal: " + bmi);

        double bmr = port.bmr(70, 1.75, 25);
        System.out.println("Calorias diarias: " + bmr);

        double fat = port.bodyFat(bmi, 25);
        System.out.println("Gordura corporal: " + fat);

        double idealWeight = port.idealWeight(1.75);
        System.out.println("Peso ideal: " + idealWeight);
    }
}
