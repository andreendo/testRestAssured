package br.edu.utfpr.testrest.testrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.specification.ProxySpecification;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author renil
 */
public class FirstTest {

    @BeforeClass
    public static void beforeClass() {
        //configuracao do proxy
//        RestAssured.proxy = ProxySpecification
//                .host("10.20.10.50")
//                .withPort(3128)
//                .withAuth("a1694103", "");    
        
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
    
    @Test
    public void testHealthCheck() {
        when().
                get("https://api.publicapis.org/health-check").
        then()
                .statusCode(200).
                body("alive", equalTo(true));
    }
    
    @Test
    public void testCategories() {
        when().
                get("https://api.publicapis.org/categories").
        then()
                .statusCode(200).
                body("$", hasItems("Animals"));
    }  
    
    @Test
    public void testSpecificCategory() {
        given().
                params("category", "animals").
        when().
                get("https://api.publicapis.org/entries").
        then()
                .statusCode(200).
                body("count", equalTo(11));
    }
}
