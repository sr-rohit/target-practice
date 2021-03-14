package com.example.samplewebconsole;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnNotWebApplication
public class ConsoleApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello from Command Line");
    }
}
