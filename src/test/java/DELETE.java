import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class DELETE {
    @BeforeEach
    public void antes() {
        RestAssured.baseURI = "http://restapi.wcaquino.me";
    }


    @Test
    @DisplayName("Deve validar o metodo DELETE")
    public void deveValidarMetodoDelete() {
        RestAssured
                .given()
                .when()
                    .delete("/users/1")
                .then()
                    .log().all()
                    .statusCode(204)
        ;
    }
}
