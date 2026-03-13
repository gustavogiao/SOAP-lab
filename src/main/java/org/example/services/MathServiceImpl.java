package org.example.services;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.example.services.MathService")
public class MathServiceImpl implements MathService{
    @Override
    public long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    private boolean isPrime(int number) {
        if(number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public int maxPrime(int a, int b) {
        int max = -1;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public int minPrime(int a, int b) {
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
