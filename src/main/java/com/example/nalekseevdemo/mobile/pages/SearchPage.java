package com.example.nalekseevdemo.mobile.pages;

import com.example.nalekseevdemo.Page;
import com.example.nalekseevdemo.mobile.MobileService;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchPage extends Page {

    public SearchPage(MobileService mobileService) {
        this.uiService = mobileService;
    }

    By searchField = MobileBy.id("org.wikipedia.alpha:id/search_src_text");
    By allProducts = new By.ByClassName("android.widget.TextView");

    public void insertText() {
        WebElement searchFieldElement = uiService.getElement(searchField);
        uiService.waitWhenClickable(searchFieldElement, 30L);
        searchFieldElement.sendKeys("BrowserStack");
    }

    public List<WebElement> getAllElementsResult() {
        try {
            Thread.sleep(5000);
            return uiService.getElements(allProducts);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
