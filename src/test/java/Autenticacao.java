import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Autenticacao {

    @Test
    @DisplayName("Deve validar autenticação - Não deve funcionar sem senha")
    public void naoDeveValidarAutenticacao() {
        RestAssured
                .given()
                .when()
                    .get("https://restapi.wcaquino.me/basicauth")
                .then()
                    .statusCode(401);

    }

    @Test
    @DisplayName("Deve validar autenticação - Deve funcionar com senha")
    public void deveValidarAutenticacao() {
        RestAssured
                .given()
                .when()
                    .get("https://admin:senha@restapi.wcaquino.me/basicauth")
                .then()
                    .statusCode(200);

    }

    @Test
    @DisplayName("Deve validar autenticação basic")
    public void deveValidarAutenticacaoBasic() {
        RestAssured
                .given()
                    .auth().basic("admin", "senha")
                .when()
                    .get("https://restapi.wcaquino.me/basicauth")
                .then()
                    .statusCode(200);

    }

    @Test
    @DisplayName("Deve validar autenticação JWT")
    public void deveValidarAutenticacaoJWT() {

        String response = RestAssured.given()
                .contentType("application/json")
                    .body("{\n" +
                            "    \"email\": \"eve.holt@reqres.in\",\n" +
                            "    \"password\": \"pistol\"\n" +
                            "}")
                    .when()
                .post("https://reqres.in/api/register")
                .then()
                    .log().body()
                    .statusCode(200)
                    .extract()
                    .path("token");

    }
}
