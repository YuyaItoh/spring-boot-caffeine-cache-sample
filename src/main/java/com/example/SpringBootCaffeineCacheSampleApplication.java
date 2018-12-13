package com.example;

import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCaffeineCacheSampleApplication implements CommandLineRunner {
    @Autowired
    private HeavyService heavyService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCaffeineCacheSampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1, 1_000_000)
                .forEach(n -> time(n, () -> heavyService.solveProblem()));
    }

    private void time(int n, Supplier<?> supplier) {
        long start = System.currentTimeMillis();
        System.out.print(n + "th call: " + supplier.get());
        long end = System.currentTimeMillis();
        System.out.println(" [" + (end - start) + "msec]");
    }
}
