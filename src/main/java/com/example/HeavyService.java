package com.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HeavyService {
    @Cacheable(cacheNames = "app")
    public String solveProblem() {
        try {
            Thread.sleep(3 * 1000);
            return "42";
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }
}
