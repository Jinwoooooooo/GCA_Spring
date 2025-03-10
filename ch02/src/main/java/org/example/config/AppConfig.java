package org.example.config;

import org.example.sub1.Greeting;
import org.example.sub1.Hello;
import org.example.sub1.Welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example"})
public class AppConfig {

    @Bean
    public Hello hello() {
        return new Hello();
    }

    @Bean
    public Welcome welcome() {
        return new Welcome();
    }

    @Bean(name = "ggg")
    public Greeting greeting() {
        return new Greeting();
    }
}
