package br.edu.utfpr.testrest.testrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static io.restassured.http.ContentType.JSON;
import io.restassured.parsing.Parser;
import io.restassured.specification.ProxySpecification;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author andreendo
 */
public class FirstTest {


    
    @Test
    public void testGet1() {
        when().
                get("https://viacep.com.br/ws/86300000/json/").
        then()
                .statusCode(200).
                body("uf", is("PR"));
    }
    
    @Test
    public void testGet2() {
        when().
                get("https://viacep.com.br/ws/26530230/json/").
        then()
                .statusCode(200).
                body("localidade", is("Nilópolis"));
    }  
    
    @Test
    public void testGet3() {
        when().
                get("https://viacep.com.br/ws/26510210/json/").
        then()
                .statusCode(200).
                body("bairro", is("Olinda"));
    }
    @Test
    public void testPost1() {
        Map<String, Object>  post = new HashMap<>();
        post.put("title", "Tiago");
        post.put("body", "teste de soft");
        post.put("userId", 1);
        given().
                contentType(ContentType.JSON).
                body(post).
        when().
                post("https://jsonplaceholder.typicode.com/posts").
        then().
                statusCode(200);
    }
    @Test
    public void testPost2() {
        Map<String, Object>  post = new HashMap<>();
        post.put("title", "Teste");
        post.put("body", "testando");
        post.put("userId", 1);
        given().
                contentType(ContentType.JSON).
                body(post).
        when().
                post("https://jsonplaceholder.typicode.com/posts").
        then().
                statusCode(200);
    }
    @Test
    public void testPost3() {
        Map<String, Object>  post = new HashMap<>();
        post.put("title", "testei");
        post.put("body", "teste");
        post.put("userId", 1);
        given().
                contentType(ContentType.JSON).
                body(post).
        when().
                post("https://jsonplaceholder.typicode.com/posts").
        then().
                statusCode(200);
    }
}
