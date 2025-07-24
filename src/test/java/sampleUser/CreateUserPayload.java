package sampleUser;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.SampleUser.SampleUserPayload.getSampleUserPayload;

public class CreateUserPayload {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .header("x-api-key","reqres-free-v1")
              // .queryParam("page","2")
                .header("Content-Type","application/json")
                .body(getSampleUserPayload())
                .when().post("/api/users")
                .then().log().all().statusCode(201);


    }
}
