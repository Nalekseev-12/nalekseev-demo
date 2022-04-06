package com.example.nalekseevdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.nalekseevdemo.**")
@PropertySource({"classpath:web.properties",
        "classpath:mobile.properties"
})
public class QaConfig {
}
