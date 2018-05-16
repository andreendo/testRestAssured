package br.edu.utfpr.testrest.testrestassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.when;
import io.restassured.parsing.Parser;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MarkVII
 */
public class PostMonTest {
    @BeforeClass
    public static void beforeClass() { 
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
    
    @Test
    public void bairroNovaCidade() {
        
        when().
                get("https://api.postmon.com.br/v1/cep/26535130").
                then()
               .statusCode(200).
                body("bairro", is("Nova Cidade"));
    }
    @Test
    public void cidadeCP() {
        
        when().
                get("https://api.postmon.com.br/v1/cep/86300000").
                then()
               .statusCode(200).
                body("cidade", is("Cornélio Procópio"));
    }
    @Test
    public void bairroJardim() {
        
        when().
                get("https://api.postmon.com.br/v1/cep/13380412").
                then()
               .statusCode(200).
                body("bairro", is("Jardim Marajoara"));
    }
    
    
}
