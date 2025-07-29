package com.sysexterne.reservation_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sysexterne.reservation_system", "Models"})
@ComponentScan(basePackages = {
        "com.sysexterne.reservation_system",
        "Models"
})
@EntityScan(basePackages = "Models.entities")
@EnableJpaRepositories(basePackages = "Models.repositories")
public class ReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationSystemApplication.class, args);
    }
}