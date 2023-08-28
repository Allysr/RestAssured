import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class Arquivos {

    @BeforeEach
    public void antes() {
        RestAssured.baseURI = "http://restapi.wcaquino.me";
    }


    @Test
    @DisplayName("Deve validar o envio de arquivo")
    public void deveValidarEnvioArquivo() {
        RestAssured
                .given()
                    .log().all()
                .multiPart("arquivo", new File("src/test/resources/imagem.png" ))
                .when()
                    .post("/upload")
                .then()
                    .log().all()
                    .statusCode(200)
        ;
    }

    @Test
    @DisplayName("Deve validar o download do arquivo")
    public void deveValidarDownloadArquivo() {
        RestAssured
                .given()
                .when()
                    .get("/download")
                .then()
                .log().all()
                .statusCode(200)
        ;
    }
}
