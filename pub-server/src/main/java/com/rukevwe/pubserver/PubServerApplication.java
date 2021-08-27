package com.rukevwe.pubserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class PubServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PubServerApplication.class, args);
    }

}
