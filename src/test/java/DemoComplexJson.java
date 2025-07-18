import io.restassured.path.json.JsonPath;

public class DemoComplexJson {

    public static void main(String[] args) {
        String respStr = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"scriptinglogic.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "     {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "       \n" +
                "  ]\n" +
                "}\n";

        System.out.println(respStr);

        JsonPath jsonPath = new JsonPath(respStr);

        // 1. Print No of courses returned by API
        int size = jsonPath.get("courses.size()");
        System.out.println("No of courses :" +size);
        //2.Print Purchase Amount
        int purchaseAmount  = jsonPath.get("dashboard.purchaseAmount");
        System.out.println("purchaseAmount=" +purchaseAmount);
        //3. Print Title of the first course

        String title1  = jsonPath.get("courses[0].title");
        System.out.println("title1=" +title1);


        //4. Print All course titles and their respective Prices

        for(int i=0;i<size;i++) {
            String title = jsonPath.get("courses["+i+"].title");
            int price = jsonPath.get("courses["+i+"].price");
            System.out.println("title=" + title + " | price=" + price);
        }


        //5. Print no of copies sold by RPA Course

        for(int i=0;i<size;i++) {


            String title = jsonPath.get("courses["+i+"].title");
            if(title.equalsIgnoreCase("RPA"))
            {
                int copies = jsonPath.get("courses["+i+"].copies");
                System.out.println("title=" + title + " | copies=" + copies);
            }




        }


        int sum = 0;
        //6. Verify if Sum of all Course prices matches with Purchase Amount
        for(int i=0;i<size;i++) {

            int price = jsonPath.get("courses["+i+"].price");
            int copies = jsonPath.get("courses["+i+"].copies");
            sum = sum + (price*copies);
        }
        System.out.println("purchaseAmount="+purchaseAmount);
        System.out.println("Sum="+sum);
    }
}
