package com.example.nalekseevdemo.mobile;

import com.example.nalekseevdemo.UIService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MobileService extends UIService {
    private final MobileDriversFactory mobileDriversFactory;

    public MobileService(MobileDriversFactory mobileDriversFactory) {
        this.mobileDriversFactory = mobileDriversFactory;
    }

    @Override
    public RemoteWebDriver getDriver() {
        if (!driverIsOpen()) {
            driver.set(mobileDriversFactory.getDriver());
            driver.get().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        }
        return driver.get();
    }
}
