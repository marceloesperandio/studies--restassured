import org.junit.jupiter.api.Test;
import utils.environments;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostTransactionsApi extends environments {

    @Test
    public void postRequestID01() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack\",\n" +
                        "    \"card_expiration_date\": \"04/28\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(200)
                .body("card_brand", containsString("visa"))
        ;
    }

    @Test
    public void postRequestID02() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"5112582290429464\",\n" +
                        "    \"card_holder_name\": \"Florus Pisani \",\n" +
                        "    \"card_expiration_date\": \"04/28\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(200)
                .body("card_brand", containsString("mastercard"))
        ;
    }

    @Test
    public void postRequestID03() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"340205901392278\",\n" +
                        "    \"card_holder_name\": \"Florus Pisani \",\n" +
                        "    \"card_expiration_date\": \"04/30\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(200)
                .body("card_brand", containsString("american-express"))
        ;
    }

    @Test
    public void postRequestID04() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Florus Pisani \",\n" +
                        "    \"card_expiration_date\": \"04/2030\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(200)
                .body("card_expiration_date", is("04/2030"))
        ;
    }

    @Test
    public void postRequestID05() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"debit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Florus Pisani \",\n" +
                        "    \"card_expiration_date\": \"04/2022\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(200)
                .body("payment_method", containsString("debit_card"))
        ;
    }

    @Test
    public void postRequestID06() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":AAAAA,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack \",\n" +
                        "    \"card_expiration_date\": \"04/30\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void postRequestID07() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack \",\n" +
                        "    \"card_expiration_date\": \"04/30\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void postRequestID08() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"1234566\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack \",\n" +
                        "    \"card_expiration_date\": \"04/30\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void postRequestID09() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack \",\n" +
                        "    \"card_expiration_date\": \"04/30\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
                .body(containsString("{\"message\":\"\\\"payment_method\\\" is not allowed to be empty\"}"))
        ;
    }

    @Test
    public void postRequestID10() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"ouro\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack\",\n" +
                        "    \"card_expiration_date\": \"04/28\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void postRequestID11() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"AAAAA\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack\",\n" +
                        "    \"card_expiration_date\": \"04/28\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
                .body(containsString("{\"message\":\"\\\"card_number\\\" must be a credit card\"}"))
        ;
    }

    @Test
    public void postRequestID12() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"12121123132132 \",\n" +
                        "    \"card_expiration_date\": \"04/28\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void postRequestID13() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack\",\n" +
                        "    \"card_expiration_date\": \"04/19\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void postRequestID14() {
        given()
                .log().all()
                .header("content-type", "application/json")
                .body("{\n" +
                        "    \"client_id\": 1,\n" +
                        "    \"amount\":12220,\n" +
                        "    \"description\": \"Apple Watch: Series 7\",\n" +
                        "    \"payment_method\": \"credit_card\",\n" +
                        "    \"card_number\": \"4497737227506309\",\n" +
                        "    \"card_holder_name\": \"Layla Kharsack\",\n" +
                        "    \"card_expiration_date\": \"04/19\",\n" +
                        "    \"card_cvv\": \"254\"\n" +
                        "}")
                .when()
                .post(apiURLStone + "/api/v1/transactions")
                .then().log().all()
                .statusCode(400)
        ;
    }
}
