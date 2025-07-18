package sampleUser;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .header("x-api-key","reqres-free-v1")
                .queryParam("page","2")
                .when().get("/api/users")
                .then().log().all().statusCode(200);


    }
}
