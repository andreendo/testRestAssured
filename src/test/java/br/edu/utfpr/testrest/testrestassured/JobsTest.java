package br.edu.utfpr.testrest.testrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.BeforeClass;


/**
 *
 * @author andreendo
 */
public class JobsTest {

    
    @BeforeClass
    public static void beforeClass() {
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
   
    @Test
    public void getAllJobsTest() {
        when().
                get("https://jobs.github.com/positions.json").
        then()
                .statusCode(200);
    }
    
    @Test
     public void getJobTitleByIdTest() {
        when().
                get("https://jobs.github.com/positions.json?search={id}", "127d9b30-5498-11e8-9a43-edfe82af2bb2")
        .then()
                .statusCode(200).
                body("title", hasItem("Software Engineer/Sr. Analyst, Investment Data & Analytics"));
    }
    
    @Test
    public void notBadJobsTest() {
        when().
                get("https://jobs.github.com/positions.json?description={id}", "cobol")
        .then()
                .statusCode(200).
                body("result.size()", equalTo(0));
    }     
}
