package com.example.nalekseevdemo.web;

import com.example.nalekseevdemo.UIService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class WebService extends UIService {
    private final WebDriversFactory webDriversFactory;

    public WebService(WebDriversFactory webDriversFactory) {
        this.webDriversFactory = webDriversFactory;
    }

    @Override
    public RemoteWebDriver getDriver() {
        if (!driverIsOpen()) {
            driver.set(webDriversFactory.getDriver());
            driver.get().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

}
