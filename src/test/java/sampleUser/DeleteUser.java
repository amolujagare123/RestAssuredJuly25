package sampleUser;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all().header("x-api-key","reqres-free-v1")
              // .queryParam("page","2")
                .header("Content-Type","application/json")
                .when().delete("/api/users/2")
                .then().log().all().statusCode(204);


    }
}
