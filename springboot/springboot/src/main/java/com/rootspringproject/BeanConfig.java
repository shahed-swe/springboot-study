package com.rootspringproject;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.rootspringproject")
public class BeanConfig {

    @Bean
    public Teacher teacher(){
        return new Teacher();
    }

    @Bean
    public Human human(){
        return new Human();
    }

}
