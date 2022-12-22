package com.isa.blood_transfusion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BloodTransfusionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloodTransfusionApplication.class, args);
    }


}
