package com.example.nalekseevdemo.steps;

import com.example.nalekseevdemo.config.QaConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = QaConfig.class)
public abstract class Steps {
}
