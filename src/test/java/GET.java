import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class GET {
    @BeforeEach
    public void antes() {
        RestAssured.baseURI = "http://restapi.wcaquino.me";
    }


    @Test
    @DisplayName("Deve validar o corpo da requisição - Apenas string")
    public void deveValidarRequisicaoString() {
        RestAssured
                .given()
                .when()
                .get("/ola")
                .then()
                .statusCode(200)
                .body(equalTo("Ola Mundo!"))
                .body(containsString("Mundo"))
                .body(is(not(nullValue())));
    }

    @Test
    @DisplayName("Deve validar o corpo da requisição - JSON")
    public void deveValidarRequisicaoJson() {
        RestAssured
                .given()
                .when()
                    .get("/users/1")
                .then()
                    .statusCode(200)
                    .body("id", is(1))
                    .body("name", containsString("João da Silva"))
                    .body("name", equalTo("João da Silva"))
                    .body("age", greaterThan(18));
    }

    @Test
    @DisplayName("Deve validar o corpo da requisição - Parametro com Objeto")
    public void deveValidarRequisicaoObjeto() {
        RestAssured
                .given()
                .when()
                    .get("/users/2")
                .then()
                    .statusCode(200)
                    .body("id", is(2))
                    .body("endereco.rua", equalTo("Rua dos bobos"));
    }

    @Test
    @DisplayName("Deve validar o corpo da requisição - Parametro com Lista de Objetos")
    public void deveValidarRequisicaoListaObjeto() {
        RestAssured
                .given()
                .when()
                .get("/users/3")
                .then()
                .statusCode(200)
                .body("id", is(3))
                .body("filhos", hasSize(2))
                .body("filhos[0].name", equalTo("Zezinho"))
        ;
    }

    @Test
    @DisplayName("Deve validar o corpo da requisição - Parametro em Lista")
    public void deveValidarRequisicaoLista() {
        RestAssured
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("", hasSize(3))
                .body("name", hasItems("João da Silva", "Maria Joaquina"))
                .body("name[1]", equalTo("Maria Joaquina"))
        ;
    }

}
