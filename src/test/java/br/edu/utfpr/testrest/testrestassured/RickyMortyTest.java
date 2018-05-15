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
 * @author LuizGuilherme
 */
public class RickyMortyTest {
    @BeforeClass
    public static void beforeClass() {    
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
    
    @Test
    public void testTemPersonagem1() {
        when().
                get("https://rickandmortyapi.com/api/character/1").
        then()
                .statusCode(200).
                body("name", is("Rick Sanchez"));
    }
    
    @Test
    public void testEpisodio10() {
        when().
                get("https://rickandmortyapi.com/api/episode/10").
        then()
                .statusCode(200).
                body("name", is("Close Rick-counters of the Rick Kind"));
    }  
    
    @Test
    public void testLocal3() {
        when().
                get("https://rickandmortyapi.com/api/location/3").
        then()
                .statusCode(200).
                body("name", is("Citadel of Ricks"));
    }      
}
