package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.GoRest.GoRestCreateUser.getGoRestCreateUserPayload;
import static payload.GoRest.GoRestCreateUser.getGoRestPayload;

public class UpdateUserPayload {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(getGoRestPayload("Amol Ujagare","amol@gmail.com","male","active"))
                .when().put("/public/v2/users/8029459")
                .then().log().all().assertThat().statusCode(200);
    }
}
