package com.example.nalekseevdemo.mobile;

import com.example.nalekseevdemo.DriversFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class MobileDriversFactory implements DriversFactory {
    @Value("${os.type:ANDROID}")
    private OS os;
    @Value("${url:http://hub.browserstack.com/wd/hub}")
    private URL url;
    @Value("${browserstack.user}")
    private String browserstackUser;
    @Value("${browserstack.key}")
    private String browserstackKey;
    @Value("${app}")
    private String app;
    @Value("${device:Samsung Galaxy S9}")
    private String device;
    @Value("${os.version}")
    private String osVersion;
    @Value("${project:First Java Project}")
    private String project;
    @Value("${build:browserstack-build-1}")
    private String build;
    @Value("${name:first_test}")
    private String name;

    @Override
    public RemoteWebDriver getDriver() {
        switch (os) {
            case ANDROID:
                return new AndroidDriver<>(url, getCapabilities());
            case IOS:
                return new IOSDriver<>(url, getCapabilities());
            default:
                throw new RuntimeException("os not supported");
        }
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserstackUser);
        caps.setCapability("browserstack.key", browserstackKey);

        // Set URL of the application under test
        caps.setCapability("app", app);

        // Specify device and os_version for testing
        caps.setCapability("device", device);
        caps.setCapability("os_version", "8.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", project);
        caps.setCapability("build", build);
        caps.setCapability("name", name);
        return caps;
    }


}
