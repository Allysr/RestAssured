import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ModoDeTestes {

    @Test
    @DisplayName("Deve validar se o status code retorna 200")
    public void deveValidarOStatusCodeMetodoUm(){
        Response response = RestAssured.request("GET", "http://restapi.wcaquino.me/ola");
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("Deve validar se o status code retorna 200")
    public void deveValidarOStatusCodeMetodoDois(){
        RestAssured.get("http://restapi.wcaquino.me/ola").then().statusCode(200);
    }

    @Test
    @DisplayName("Deve validar se o status code retorna 200")
    public void deveValidarOStatusCodeMetodoTres(){
        RestAssured.given().when().get("http://restapi.wcaquino.me/ola").then().statusCode(200);
    }
}
