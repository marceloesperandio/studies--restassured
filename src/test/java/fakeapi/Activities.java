package fakeapi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Activities {

    @Test
    public void getActivities() {
        given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/index.html")
                .then()
                .statusCode(200)
        ;
    }
}