package org.example.services;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.example.services.HealthService")
public class HealthServiceImpl implements HealthService {
    @Override
    public double bmi(double weight, double height) {
        return weight / (height * height);
    }

    @Override
    public double bmr(double weight, double height, int age) {
        return (10 * weight) + (6.25 * height) - (5 * age) + 5;
    }

    @Override
    public double bodyFat(double bmi, int age) {
        return (1.2 * bmi) - (0.23 * age) - 16.2;
    }

    @Override
    public double idealWeight(double height) {
        return 22 * height * height;
    }
}
