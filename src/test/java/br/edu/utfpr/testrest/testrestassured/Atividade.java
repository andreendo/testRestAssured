package br.edu.utfpr.testrest.testrestassured;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class Atividade {

    @Test
    public void testGet() {
        when()
                .get("https://api.spacexdata.com/v2/launches/latest")
        .then()
                .statusCode(200)
                .body("flight_number", equalTo(68))
                .body("mission_name", equalTo("Telstar 18V"));
    }

    @Test
    public void testPost() {
        Map<String, Object> body = new HashMap<>();
        body.put("token", "-3VTZ0WQ7GZ25lNlTdpVJg");

        Map<String, Object> data = new HashMap<>();
        data.put("name", "Diego");
        data.put("email", "diegovarela.paiva@hotmail.com");
        data.put("nickname", "divarela");
        data.put("gender", "male");

        body.put("data", data);

        given()
                .contentType(ContentType.JSON)
                .body(body)
        .when()
                .post("https://app.fakejson.com/q")
        .then()
                .statusCode(200)
                .body("name", equalTo("Diego"))
                .body("email", equalTo("diegovarela.paiva@hotmail.com"))
                .body("nickname", equalTo("divarela"))
                .body("gender", equalTo("male"));
    }

}