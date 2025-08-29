package sampleUser;

import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;


public class DeleteUserSPec {

    @Test
    public void deleteUserTest()
    {
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();


        RequestSpecification request = given().log().all().spec(reqSpec);


        Response response = request.when().delete("/api/users/2");

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
        String respStr = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println("respStr="+respStr);



    }
}
