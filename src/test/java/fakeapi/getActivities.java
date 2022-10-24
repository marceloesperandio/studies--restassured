package fakeapi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getActivities {

    @Test
    public void validarStatusCode() {
        given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities/1")
                .then()
                .statusCode(200)
                .body("title", containsString("Activity 1"))
                .body("dueDate", greaterThan("2022-10-24T00:52:01.9727697+00:00"))
                .body("completed", is(false))
        ;
    }
}