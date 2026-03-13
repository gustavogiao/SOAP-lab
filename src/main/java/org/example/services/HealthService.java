package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface HealthService {
    @WebMethod
    double bmi(@WebParam(name = "weight") double weight,
               @WebParam(name = "height") double height);

    @WebMethod
    double bmr(@WebParam(name = "weight") double weight,
               @WebParam(name = "height") double height,
               @WebParam(name = "age") int age);

    @WebMethod
    double bodyFat(@WebParam(name="bmi") double bmi,
                   @WebParam(name="age") int age);

    @WebMethod
    double idealWeight(@WebParam(name="height") double height);
}
