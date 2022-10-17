package fakeapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class apiActivities {

    public static void main(String[] args) {
        Response response = RestAssured.request(Method.GET, "https://fakerestapi.azurewebsites.net/api/v1/Activities");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode() == 200);

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }
}
