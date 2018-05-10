package br.edu.utfpr.testrest.testrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

public class GhibliTest {

    public String baseURL = "https://ghibliapi.herokuapp.com";

    @BeforeClass
    public static void beforeClass() {
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    public void testFilms() {
        when()
                .get(url("/films"))
                .then()
                .statusCode(200);

        String body = when().get(url("/films")).getBody().prettyPrint();
        Assert.assertTrue(body.contains("2baf70d1-42bb-4437-b551-e5fed5a87abe"));
    }

    @Test
    public void testFilmsWithId() {
        Response res
                = given().params("id", "5fdfb320-2a02-49a7-94ff-5ca418cae602")
                        .when().get(url("/films"));

        res.then().statusCode(200);

        String body = res.jsonPath().prettify();

        Assert.assertTrue(body.contains("When Marnie Was There"));
        Assert.assertFalse(body.contains("Castle in the Sky"));
    }

    @Test
    public void testVehicles() {
        Response res = get(url("/vehicles"));

        res.then().statusCode(200);

        String body = res.jsonPath().prettify();

        Assert.assertTrue(body.contains("4e09b023-f650-4747-9ab9-eacf14540cfb"));
        Assert.assertTrue(body.contains("d8f893b5-1dd9-41a1-9918-0099c1aa2de8"));
        Assert.assertTrue(body.contains("923d70c9-8f15-4972-ad53-0128b261d628"));

    }
    
    @Test
    public void testVehiclesWithId() {
        Response res = given().params("id", "4e09b023-f650-4747-9ab9-eacf14540cfb").with().get(url("/vehicles"));

        res.then().statusCode(200);

        String body = res.jsonPath().prettify();

        Assert.assertTrue(body.contains("4e09b023-f650-4747-9ab9-eacf14540cfb"));
        Assert.assertFalse(body.contains("d8f893b5-1dd9-41a1-9918-0099c1aa2de8"));
        Assert.assertFalse(body.contains("923d70c9-8f15-4972-ad53-0128b261d628"));

    }

    private String url(String URI) {
        return this.baseURL + URI;
    }
}
