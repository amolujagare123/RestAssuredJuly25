package sampleUser;


import POJO.SampleAPIResponse;
import POJO.SampleUserPOJO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.SampleUser.SampleUserPayload.getSampleUserPayload;

public class CreateUserPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        SampleUserPOJO ob = new SampleUserPOJO();
        ob.setName("Aarsi");
        ob.setJob("Test Lead");

        SampleAPIResponse resp = given().log().all()
                .header("x-api-key", "reqres-free-v1")
                // .queryParam("page","2")
                .header("Content-Type", "application/json")
                .body(ob)
                .when().post("/api/users")
                .then().log().all().statusCode(201).extract().as(SampleAPIResponse.class);

        String name = resp.getName();
        String job = resp.getJob();
        String id = resp.getId();
        String createdAt = resp.getCreatedAt();

        System.out.println("name="+name);
        System.out.println("job="+job);
        System.out.println("id="+id);
        System.out.println("createdAt="+createdAt);

    }
}
