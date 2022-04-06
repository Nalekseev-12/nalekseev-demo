package com.example.nalekseevdemo.web.pages;

import com.example.nalekseevdemo.Page;
import com.example.nalekseevdemo.web.WebService;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class HabrBlogPage extends Page {
    By foundingDate = By.xpath("(//*[@class='tm-description-list__body tm-description-list__body_variant-columns-nowrap'])[1]");

    protected HabrBlogPage(WebService webService) {
        this.uiService = webService;
    }

    public String getFoundingDate() {
        return uiService.getElement(foundingDate).getText();
    }
}
