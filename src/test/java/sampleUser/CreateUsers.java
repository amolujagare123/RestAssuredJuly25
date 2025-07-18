package sampleUser;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .header("x-api-key","reqres-free-v1")
              // .queryParam("page","2")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().statusCode(201);


    }
}
