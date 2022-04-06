package com.example.nalekseevdemo.steps;

import com.example.nalekseevdemo.web.pages.HabrBlogPage;
import com.example.nalekseevdemo.web.pages.MainPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WebSteps extends Steps{
    private final MainPage mainPage;
    private final HabrBlogPage habrBlogPage;

    public WebSteps(MainPage mainPage, HabrBlogPage habrBlogPage) {
        this.mainPage = mainPage;
        this.habrBlogPage = habrBlogPage;
    }

    @Дано("переходим на главную страницу")
    public void goToMainPage() {
        mainPage.goToMainPage();
    }

    @Когда("кликаем на блог Хабр")
    public void clickHabtBlogButton() {
        mainPage.clickHabrBlogButton();
    }

    @Тогда("проверяем что дата основания равна 26 мая 2006")
    public void checkFoundingDate() {
        String date = habrBlogPage.getFoundingDate();
        assertThat(date, equalTo("26 мая 2006"));
    }

    @Когда("устанавливаем фильтры, лучшие за все время")
    public void setFiltersBestOfAllTime() {
        mainPage.openFilters();
        mainPage.clickBestButton();
        mainPage.chooseAllTime();
        mainPage.clickApply();
    }

    @Тогда("проверяем что дата первого поста 27 ноября 2011 в 23:21")
    public void checkDateOfFirstPost() {
        String date = mainPage.getDateOfFirstPost();
        assertThat(date, equalTo("27 ноября 2011 в 23:21"));
    }
}
