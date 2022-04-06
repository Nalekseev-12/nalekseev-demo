package com.example.nalekseevdemo.steps;

import com.example.nalekseevdemo.rest.UserRestService;
import com.example.nalekseevdemo.rest.pojo.User;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;

public class RestSteps extends Steps{
    private final UserRestService userRestService;

    public RestSteps(UserRestService userRestService) {
        this.userRestService = userRestService;
    }

    private static final User NEW_USER;

    static {
        NEW_USER = new User();
        NEW_USER.setEmail("email@gmail.ru");
        NEW_USER.setFirstName("first name");
        NEW_USER.setLastName("last name");
        NEW_USER.setPassword("password");
        NEW_USER.setUsername("username");
    }

    @Тогда("создаем нового пользователя и проверям что код статуса ответа 200")
    public void createNewUserAndCheckResponse200() {
        Response response = userRestService.createUser(NEW_USER);
        userRestService.checkResponseCode200(response);
    }

    @Тогда("логинимся и проверяем код статуса ответа 200")
    public void loginAndCheckResponse200() {
        Response response = userRestService.loginUser(NEW_USER);
        userRestService.checkResponseCode200(response);
    }
}
