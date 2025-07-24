package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.GoRest.GoRestCreateUser.getGoRestCreateUserPayload;

public class GetAllUserPayload {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .when().get("/public/v2/users")
                .then().log().all().assertThat().statusCode(200);
    }
}
