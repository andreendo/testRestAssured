package br.edu.utfpr.testrest.testrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import org.junit.Test;
import org.junit.BeforeClass;


/**
 *
 * @author andreendo
 */
public class GetAndPostTest {
    
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
    public void getAPI(){
        when().
            get("http://api.dataatwork.org/v1/spec/skills-api.json").
        then().
            statusCode(200).
            body("info.title", equalTo("Open Skills API"));
    }
    
    @Test
    public void getJob(){
        when().
            get("http://api.dataatwork.org/v1/jobs/26bc4486dfd0f60b3bb0d8d64e001800").
        then().
            statusCode(200).
            body("title", equalTo("1st Grade Teacher"));
    }
    
    @Test
    public void getSkill(){
        when().
            get("http://api.dataatwork.org/v1/skills/02eb7ff7569c9beedda699580d679557").
        then().
            statusCode(200).
            body("skill_name", equalTo("0-1 drop indicators"));
    }
    
    @Test
    public void postJob() {
        Response res = given().
                params("uuid", "8576a78b5c1cae3a567ca7fd34500357").
        when().
                get("http://api.dataatwork.org/v1/jobs");
        
        res.body().prettyPrint();
    }
    
    @Test
    public void postSkill() {
        Response res = given().
                params("uuid", "b09a37a84b8a7b7efcc174a96a599c83").
        when().
                get("http://api.dataatwork.org/v1/skills");
        
        res.body().prettyPrint();
    }
}
