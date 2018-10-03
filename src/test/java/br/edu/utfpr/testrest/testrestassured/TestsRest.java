package br.edu.utfpr.testrest.testrestassured;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.ProxySpecification;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author KamillaDallmann
 */
public class TestsRest {
   
    
    @Test
    public void testNames() {
        when().
                get("https://parallelum.com.br/fipe/api/v1/carros/marcas").
        then()
                .statusCode(200).
                body("nome", hasItems("Acura", "Saturn"));
    }
    
    @Test
    public void testMarcaSize() {
        when().
                get("https://parallelum.com.br/fipe/api/v1/carros/marcas/163/modelos").
        then()
                .statusCode(200).
                body("modelos.size()", is(2)).
                and().
                body("anos.size()", is(11));
    }    
    
    @Test
    public void testPost3() {
        Map<Object, String>  marca = new HashMap<>();
        marca.put("nome", "KamillaTeste");
   
        given().
                contentType(ContentType.JSON).
                body(marca).
        when().
                post("https://parallelum.com.br/fipe/api/v1/carros/marcas").
        then().
                statusCode(200).
                body("codigo", is(not("")));
    }
    
    
}
