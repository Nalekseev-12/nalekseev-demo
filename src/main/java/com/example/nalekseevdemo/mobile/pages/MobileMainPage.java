package com.example.nalekseevdemo.mobile.pages;

import com.example.nalekseevdemo.Page;
import com.example.nalekseevdemo.mobile.MobileService;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class MobileMainPage extends Page {
    public MobileMainPage(MobileService mobileService) {
        this.uiService = mobileService;
    }

    By searchButton = MobileBy.AccessibilityId("Search Wikipedia");

    public void clickSearchButton() {
        WebElement searchButtonElement = uiService.getElement(searchButton);
        uiService.waitWhenClickable(searchButtonElement, 30L);
        searchButtonElement.click();
    }
}
