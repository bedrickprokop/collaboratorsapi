package br.com.collaboratorsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.collaboratorsapi")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
