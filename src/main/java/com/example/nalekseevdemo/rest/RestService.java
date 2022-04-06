package com.example.nalekseevdemo.rest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class RestService {
    static final String BASIC_URL = "https://petstore.swagger.io/";

    public void checkResponseCode200(Response response) {
        assertThat(response.statusCode(), equalTo(200));
    }

    RequestSpecification createRequest() {
        return given()
                .filter(new AllureRestAssured());
    }
}
