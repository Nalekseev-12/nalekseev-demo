package com.example.nalekseevdemo.web.pages;

import com.example.nalekseevdemo.Page;
import com.example.nalekseevdemo.web.WebService;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends Page {
    private static final String URL = "https://habr.com/";

    By habrBlogButton = By.xpath("//*/span[text()='Хабр']");
    By navigationFilterButton = By.xpath("//*[@class='tm-navigation-filters__button']");
    By allTimePeriodButton = By.xpath("(//*[@class='tm-navigation-filters__option-button'])[5]");
    By applyButton = By.xpath("//*[@class='tm-navigation-filters__apply btn btn_solid btn_small']");
    By dateOfFirstPost = By.xpath("(//*[@class='tm-article-snippet__datetime-published'])[1]/time");
    By bestButton = By.xpath("(//*[@class='tm-navigation-filters__option-button'])[1]");

    protected MainPage(WebService webService) {
        this.uiService = webService;
    }

    public void goToMainPage() {
        uiService.getDriver().get(URL);
    }

    public void openFilters() {
        uiService.getElement(navigationFilterButton).click();
    }

    public void chooseAllTime() {
        uiService.getElement(allTimePeriodButton).click();
    }

    public void clickApply() {
        uiService.getElement(applyButton).click();
    }

    public void clickBestButton() {
        uiService.getElement(bestButton).click();
    }

    public String getDateOfFirstPost() {
        return uiService.getElement(dateOfFirstPost).getText();
    }

    public void clickHabrBlogButton() {
        uiService.getElement(habrBlogButton).click();
    }
}
