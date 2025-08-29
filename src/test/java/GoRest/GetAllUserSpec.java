package GoRest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUserSpec {

    @Test
    public void getAllUsers()
    {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpec);

        Response response = request.when().get("/public/v2/users");

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String respStr = response.then().log().all().spec(responseSpec).extract().asString();

        System.out.println("respStr = " + respStr);

    }
}
