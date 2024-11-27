package com.example.msa_commentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsaCommentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaCommentServiceApplication.class, args);
    }

}
