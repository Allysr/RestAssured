import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PUT {
    @BeforeEach
    public void antes() {
        RestAssured.baseURI = "http://restapi.wcaquino.me";
    }


    @Test
    @DisplayName("Deve validar o metodo PUT")
    public void deveValidarMetodoPut() {
        RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body("{" +
                        "\"name\":\"Ana Bonitona\",\n" +
                        "\"age\":30,\n" +
                        "\"salary\":1234.5678\n" +
                        "}")
                .when()
                    .put("/users/1")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("name", equalTo("Ana Bonitona"))
        ;
    }
}
