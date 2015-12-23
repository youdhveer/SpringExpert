package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({ "com.example.config", "com.example.seq", "com.example.hosting" })
@Import({ MongoConfig.class })
public class AppConfig {

}