package GoRest;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static payload.GoRest.GoRestCreateUser.getGoRestPayload;

public class UpdateUserPayloadJSON {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://gorest.co.in/";

        Path path = Paths.get("JsonPayload/GoRest.json");
        byte[] bytes = Files.readAllBytes(path);
        String jsonPayLoad = new String(bytes);

        given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(jsonPayLoad)
                .when().put("/public/v2/users/8029459")
                .then().log().all().assertThat().statusCode(200);
    }
}
