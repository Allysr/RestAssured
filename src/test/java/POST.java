import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class POST {

        @BeforeEach
        public void antes() {
            RestAssured.baseURI = "http://restapi.wcaquino.me";
        }


        @Test
        @DisplayName("Deve validar o metodo POST")
        public void deveValidarMetodoPost() {
            RestAssured
                    .given()
                        .log().all()
                        .contentType("application/json")
                        .body("{" +
                                "\"name\":\"Ana Bonita\",\n" +
                                "\"age\":30,\n" +
                                "\"salary\":1234.5678\n" +
                                "}")
                    .when()
                        .post("/users")
                    .then()
                        .log().all()
                        .statusCode(201)
                        .body("name", equalTo("Ana Bonita"))
                    ;
        }
}

