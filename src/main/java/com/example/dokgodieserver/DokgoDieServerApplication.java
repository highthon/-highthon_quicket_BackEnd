package com.example.dokgodieserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DokgoDieServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DokgoDieServerApplication.class, args);
    }

}
