package br.edu.utfpr.testrest.testrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.specification.ProxySpecification;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.BeforeClass;

public class dogceoTest {

    @BeforeClass
    public static void beforeClass() {
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    public void dogAleatorio() {
        when().
                get("https://dog.ceo/api/breeds/image/random").
                then()
                .statusCode(200).
                body("status", is("success"));

    }

    @Test
    public void dogListarRacas() {
        when().
                get("https://dog.ceo/api/breed/hound/images").
                then()
                .statusCode(200).
                body("status", is("success"));
    }

    @Test
    public void dodListarSubracas() {
        when().
                get("https://dog.ceo/api/breed/hound/list").
                then()
                .statusCode(200).
                body("status", is("success"));
    }
    
     @Test
    public void testDogPost() {

        when().
                post("https://dog.ceo/api/breeds/image/random").
        then()
                .statusCode(200).
                body("codigo", is(not("")));
    }     
}
