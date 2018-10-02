package br.edu.utfpr.testrest.testrestassured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 *
 * @author dafnyg
 * 
 */
public class CatApiTest {

    @Test
    public void testGetRandomCatPic() {
        when().
                get("https://api.thecatapi.com/v1/images/search").
        then()
                .statusCode(200).
                body("url", is(not("")));
    }

    @Test
    public void testGetCatPicById() {
        when().
                get("https://api.thecatapi.com/v1/images/945").
        then()
                .statusCode(200).
                body("id", is("945")).
                body("url", is(not("")));
    }
    
    @Test
    public void testPostNewCatPic(){
        when().
                post("https://api.thecatapi.com/v1/images/upload").
        then()
                .statusCode(401).
                header("Content-Type", startsWith("application/json"));
    }
}