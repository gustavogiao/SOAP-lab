package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface MathService {
    @WebMethod
    long factorial(@WebParam(name = "number") int number);

    @WebMethod
    int maxPrime(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

    @WebMethod
    int minPrime(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

    @WebMethod
    int sum(@WebParam(name = "numbers") int[] numbers);
}