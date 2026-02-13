package com.example.libraryapi;

import com.example.libraryapi.patterns.singleton.LibraryConfigSingleton;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initSingleton(Environment env) {
        return args -> LibraryConfigSingleton.getInstance().loadFromEnv(env);
    }
}