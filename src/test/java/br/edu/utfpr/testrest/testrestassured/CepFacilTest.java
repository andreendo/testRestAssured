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
public class CepFacilTest {

    @Test
    public void testCepSeSaoPaulo() {
        when().
                get("https://viacep.com.br/ws/01001000/json/").
                then()
                .statusCode(200).
                body("bairro", is("Sé"));
    }

    @Test
    public void testCepPalmital() {
        when().
                get("https://viacep.com.br/ws/19970000/json/").
                then()
                .statusCode(200).
                body("localidade", is("Palmital"));
    }

    @Test
    public void testCepInvalidoComLetra() {
        when().
                get("https://viacep.com.br/ws/000e00000/json/").
                then()
                .statusCode(400);
    }

    @Test
    public void testCepInvalidoNoFormato() {
        when().
                get("https://viacep.com.br/ws/99999999/json/")
                .then()
                .statusCode(200)
                .body("erro", is(Boolean.TRUE));
    }

    @Test
    public void testCepPost() {
        when().
                post("https://viacep.com.br/ws/")
                .then()
                .statusCode(400);
    }

    @Test
    public void testCepPut() {
        when().
                put("https://viacep.com.br/ws/19970000")
                .then()
                .statusCode(400);
    }

    @Test
    public void testCepDelete() {
        when().
                delete("https://viacep.com.br/ws/19970000")
                .then()
                .statusCode(400);
    }
}
