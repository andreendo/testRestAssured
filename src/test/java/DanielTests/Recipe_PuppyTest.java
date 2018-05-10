package DanielTests;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.specification.ProxySpecification;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author White
 */
public class Recipe_PuppyTest {
    @BeforeClass
    public static void beforeClass() {
        //configuracao do proxy
        RestAssured.proxy = ProxySpecification
                .host("10.20.10.50")
                .withPort(3128)
                .withAuth("usuario", "senha");    
        
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
    
    @Test
    public void testReceitaComBatata() {
        when().
                get("http://www.recipepuppy.com/api/?i=potato").
        then()
                .statusCode(200).
                body("$", hasItem("potato"));
    }
    
    @Test
    public void testReceitaComBanana() {
        when().
                get("http://www.recipepuppy.com/api/?i=banana").
        then()
                .statusCode(200).
                body("$", hasItem("banana"));
    }
    
    @Test
    public void testNãoTemReceitasComBacon() {
        when().
                get("http://www.recipepuppy.com/api/?i=bacom").
        then()
                .statusCode(200).
                body("result.size()", equalTo(0));
                //body("result.size()", is(0));
    }
}
