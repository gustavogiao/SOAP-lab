package org.example.services;

import jakarta.jws.WebService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebService(endpointInterface = "org.example.services.TimeService")
public class TimeServiceImpl implements TimeService{

    @Override
    public String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @Override
    public String getDateTimeFormatted(String format) {
        try{
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
        }catch (Exception e){
            return "Invalid format: " + format;
        }
    }
}
