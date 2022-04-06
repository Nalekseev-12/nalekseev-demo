package com.example.nalekseevdemo.utils;

import com.example.nalekseevdemo.mobile.MobileService;
import com.example.nalekseevdemo.web.WebService;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

public class Hooks {

    private final WebService webService;
    private final MobileService mobileService;

    public Hooks(WebService webService, MobileService mobileService) {
        this.webService = webService;
        this.mobileService = mobileService;
    }

    @After(order = 1)
    public void closeDriver() {
        webService.closeDriver();
        mobileService.closeDriver();
    }

    @After
    public void createScreenshotFailed(Scenario scenario) {
        if (scenario.isFailed() && webService.driverIsOpen()) {
            scenario.attach(webService.getDriver().getScreenshotAs(OutputType.BYTES),
                    "image/png",
                    "screenshot on failure");
        }
        if (scenario.isFailed() && mobileService.driverIsOpen()) {
            scenario.attach(mobileService.getDriver().getScreenshotAs(OutputType.BYTES),
                    "image/png",
                    "screenshot on failure");
        }
    }
}
