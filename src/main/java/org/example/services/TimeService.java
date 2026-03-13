package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface TimeService {
    @WebMethod
    String getTime();

    @WebMethod
    String getDate();

    @WebMethod
    String getDateTime();

    @WebMethod
    String getDateTimeFormatted(@WebParam(name = "format") String format);
}
