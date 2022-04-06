package com.example.nalekseevdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;
import java.util.List;

public abstract class UIService {
    @Value("${default.timeout:30}")
    protected Long timeout;

    protected final ThreadLocal<RemoteWebDriver> driver;

    protected UIService() {
        driver = new ThreadLocal<>();
            }

    public abstract RemoteWebDriver getDriver();

    public boolean driverIsOpen() {
        return driver.get() != null && driver.get().getSessionId() != null;
    }

    public void closeDriver() {
        if (driverIsOpen()) {
            driver.get().quit();
            driver.remove();
        }
    }

    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    public WebDriverWait createWebDriverWait(Long time) {
        return new WebDriverWait(getDriver(), time);
    }

    public void waitWhenClickable(WebElement webElement, Long time) {
        createWebDriverWait(time).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}

