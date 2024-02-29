package com.qacart.todo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restAssuredCookies;
    @JsonProperty("access_token")
    private String accessToken;
    private String userID;
    private String firstName;

    public List<Cookie> getCookies() {
        return this.restAssuredCookies;
    }

    @JsonProperty("access_token")
    public String getAccesToken() {
        return this.accessToken;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void register() {

        User user = UserUtils.generateRandomUser();

        Response response =
                given()
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type", "application/json")
                        .body(user)
                        .log().all()
                        .when()
                        .post(EndPoint.API_REGISTER_ENDPOINT)
                        .then()
                        .log().all()
                        .extract().response();

        if (response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with request");
        }

        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");
        firstName = response.path("firstName");

    }

}
