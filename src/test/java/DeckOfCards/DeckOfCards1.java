package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class DeckOfCards1 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        String respShuffleStr = given().log().all()
                .queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle")
                .then().log().all().statusCode(200)
                .extract().asString();

        System.out.println("resp="+respShuffleStr);

        JsonPath jsonPath = new JsonPath(respShuffleStr);

      //  boolean success = jsonPath.getBoolean("success");
        boolean success = jsonPath.get("success");
        String deckId = jsonPath.get("deck_id");
        int remaining = jsonPath.get("remaining");
        boolean shuffled = jsonPath.get("shuffled");

        System.out.println("success="+success);
        System.out.println("deckId="+deckId);
        System.out.println("remaining="+remaining);
        System.out.println("shuffled="+shuffled);

        String respDrawStr = given().log().all()
                .queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw")
                .then().log().all().statusCode(200)
                .extract().response().asString();

        JsonPath jsonPath2 = new JsonPath(respDrawStr);

        String code1 = jsonPath2.get("cards[0].code");
        String code2 = jsonPath2.get("cards[1].code");
        String image1 = jsonPath2.get("cards[0].image");
        String image2 = jsonPath2.get("cards[0].image");
        String imagePNG1 = jsonPath2.get("cards[0].images.svg");
        String imagePNG2 = jsonPath2.get("cards[1].images.svg");

        System.out.println("code1="+code1);
        System.out.println("code2="+code2);
        System.out.println("image1="+image1);
        System.out.println("image2="+image2);
        System.out.println("imagePNG1="+imagePNG1);
        System.out.println("imagePNG2="+imagePNG2);
    }

}
