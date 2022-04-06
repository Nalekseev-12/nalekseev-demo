package com.example.nalekseevdemo.steps;

import com.example.nalekseevdemo.mobile.MobileService;
import com.example.nalekseevdemo.mobile.pages.MobileMainPage;
import com.example.nalekseevdemo.mobile.pages.SearchPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class MobileSteps extends Steps{
    private final MobileService mobileService;
    private final MobileMainPage mobileMainPage;
    private final SearchPage searchPage;

    public MobileSteps(MobileService mobileService, MobileMainPage mobileMainPage, SearchPage searchPage) {
        this.mobileService = mobileService;
        this.mobileMainPage = mobileMainPage;
        this.searchPage = searchPage;
    }

//    @Когда("нажимаем на поле поиска")
//    public void
    @Когда("выполняем поиск по фразе Browser Stack")
    public void searchBrowserStack() {
        mobileMainPage.clickSearchButton();
        searchPage.insertText();
    }

    @Тогда("проверяем что выданных результатов больше 0")
    public void checkResults() {
        List<WebElement> webElements = searchPage.getAllElementsResult();
        assertThat(webElements.size(), greaterThan(0));
    }
}
