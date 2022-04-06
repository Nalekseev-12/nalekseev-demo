package com.example.nalekseevdemo.rest;

import com.example.nalekseevdemo.rest.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class UserRestService extends RestService{
    private static final String CREATE_USER_URL = BASIC_URL + "v2/user";

    public Response createUser(User user) {
        return createRequest()
                .contentType(ContentType.JSON)
                .body(user)
                .post(CREATE_USER_URL);
    }

    public Response loginUser(User user) {
        String url = BASIC_URL + "login?" + "username=" + user.getUsername() + "&"+"password" + "=" + user.getPassword();
        return createRequest()
                .get(url);
    }
}
