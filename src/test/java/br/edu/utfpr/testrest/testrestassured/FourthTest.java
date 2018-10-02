package br.edu.utfpr.testrest.testrestassured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 *
 * @author andreendo
 * 
 * Testes para o projeto LivrosREST
 */
public class FourthTest {

    @Test
    public void testDogGetRandomShiba() {
        when().
                get("https://dog.ceo/api/breed/shiba/images/random").
        then()
                .statusCode(200).
                body("message", startsWith("https://images.dog.ceo/breeds/shiba/shiba-"));
    }

    @Test
    public void testDogGetListOfHounds() {
        when().
                get("https://dog.ceo/api/breed/hound/list").
        then()
                .statusCode(200).
                body("message.size()", is(6));
    }
}