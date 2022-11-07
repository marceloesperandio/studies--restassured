package api;

import body.ActivitiesBody;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import utils.environments;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ActivitiesApi extends environments {

    ActivitiesBody activitiesBody = new ActivitiesBody();

    @Test
    public void getRequest() {
        JSONObject requestParams = new JSONObject();
        given()
                .when()
                .get(apiFakerestapi + "/api/v1/Activities")
                .then().log().all()
                .statusCode(200)
                .body("title", containsString("Activity 1"))
                .body("dueDate", greaterThan("2022-10-24T00:52:01.9727697+00:00"))
                .body("completed", is(false))
        ;
    }

    @Test
    public void postRequest() {
        given()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"title\": \"string\",\n" +
                        "  \"dueDate\": \"2022-11-07T21:04:09.870Z\",\n" +
                        "  \"completed\": true\n" +
                        "}")
                .when().log().all()
                .post(apiFakerestapi + "/api/v1/Activities")
                .then().log().all()
                .statusCode(200)
                .body("title", containsString("Activity 1"))
                .body("dueDate", greaterThan("2022-10-24T00:52:01.9727697+00:00"))
                .body("completed", is(false))
                .extract().response();
        ;
    }

    @Test
    public void getActivitiesId() {
        Response response = given()
                .when().log().all()
                .get(apiFakerestapi + "/api/v1/Activities/5")
                .then().log().all()
                .statusCode(200)
                .body("title", containsString("Activity 5"))
                .body("dueDate", greaterThan("2022-10-24T00:52:01.9727697+00:00"))
                .body("completed", is(false))
                .extract().response();
        ;
    }

}