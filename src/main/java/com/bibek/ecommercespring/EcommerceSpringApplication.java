package com.bibek.ecommercespring;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class EcommerceSpringApplication {

    public static void main(String[] args) {

        Dotenv dotenv  = Dotenv.configure().load();
        dotenv.entries().forEach(
                dotenvEntry ->  {
                    System.setProperty(
                        dotenvEntry.getKey(),
                        dotenvEntry.getValue());
                    log.info("{}: {}", dotenvEntry.getKey(), dotenvEntry.getValue());
                }
        );

        SpringApplication.run(EcommerceSpringApplication.class, args);
    }

}
