package ChatServer;

import POJO.ChatServer;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateChatUsersSpec {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";

       /* PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("demo");*/


        ChatServer ob = new ChatServer();
        ob.setUsername("chatuser123");
        ob.setPassword("secure@123");
        ob.setEmail("chatuser@example.com");
        ob.setName("Deevakar");
        ob.setSurname("Patel");
        ob.setChat_nickname("DeeChat");

        ob.setDepartments(List.of(1, 2));
        ob.setDepartments_read(List.of(2));
        ob.setDepartment_groups(List.of(1));
        ob.setUser_groups(List.of(1));


       /* given().log().all()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","demo")
                .body(ob)
                .when().post("/restapi/user")
                .then().log().all().statusCode(200);*/


        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("demo");

        RequestSpecification createUserRequestSpec = new RequestSpecBuilder()
                .setBaseUri("https://demo.livehelperchat.com/site_admin")
                .setContentType("application/json")
                .setAuth(auth)
                .build();

        RequestSpecification request = given().log().all().spec(createUserRequestSpec).body(ob);

        Response response = request.when().post("/restapi/user");

        ResponseSpecification respCreateUser = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String respStr = response.then().log().all()
                .spec(respCreateUser)
                .extract().asString();

        System.out.println("respStr="+respStr);
    }
}
