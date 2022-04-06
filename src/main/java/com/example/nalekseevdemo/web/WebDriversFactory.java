package com.example.nalekseevdemo.web;

import com.example.nalekseevdemo.DriversFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebDriversFactory implements DriversFactory {

    @Value("${browser.name:CHROME}")
    private Browser browser;
    @Value("${headless.mode}")
    private boolean headlessMode;

    public RemoteWebDriver getDriver() {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(getChromeOptions());
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new RuntimeException("browser not supported");
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headlessMode) {
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
    }
}
