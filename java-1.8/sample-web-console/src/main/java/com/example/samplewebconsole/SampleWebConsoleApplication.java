package com.example.samplewebconsole;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SampleWebConsoleApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(SampleWebConsoleApplication.class);
        if (args.length == 0) {
            app.web(WebApplicationType.SERVLET);
        } else {
            app.web(WebApplicationType.NONE);
        }
        app.run(args);
    }
}
