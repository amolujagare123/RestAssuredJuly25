package DeckOfCards;

import POJO.DeckOfCardsShuffled;
import POJO.GoRESTPojo;
import POJO.RespDraw;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class DeckOfCards2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        DeckOfCardsShuffled respShuffle = given().log().all()
                .queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle")
                .then().log().all().statusCode(200)
                .extract().as(DeckOfCardsShuffled.class);

        String deckId = respShuffle.getDeck_id();

        System.out.println("deck id ="+respShuffle.getDeck_id());
        System.out.println("Remaining ="+respShuffle.getRemaining());
        System.out.println("Shuffled ="+respShuffle.isShuffled());
        System.out.println("Success ="+respShuffle.isSuccess());


        RespDraw respDraw = given().log().all()
                .queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw")
                .then().log().all().statusCode(200)
                .extract().response().as(RespDraw.class);

        boolean Success = respDraw.isSuccess();
        String Deck_id =  respDraw.getDeck_id();
        int remaining = respDraw.getRemaining();


        System.out.println(respDraw.getCards().get(0).getCode());
        System.out.println(respDraw.getCards().get(0).getImage());
    }

}
