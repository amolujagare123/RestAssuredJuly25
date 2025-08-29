package sampleUser;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersSpec {

    @Test
    public void getAllUsersSpec()
    {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpec)
                .queryParam("page", "2");

        Response response = request.when().get("/api/users");

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String responseStr = response.then().log().all().spec(responseSpec).extract().asString();

        System.out.println("responseStr = "+responseStr);
    }
}
