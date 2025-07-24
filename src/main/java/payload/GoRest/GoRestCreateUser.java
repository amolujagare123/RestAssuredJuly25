package payload.GoRest;

public class GoRestCreateUser {

    public static  String getGoRestCreateUserPayload()
    {
        return " {\n" +
                "    \"name\": \"Amol Ujagare\",\n" +
                "    \"email\": \"amol@prosacco.test\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "  }";
    }


    public static  String getGoRestPayload(String name,String email,String gender,String status)
    {
        return " {\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"gender\": \""+gender+"\",\n" +
                "    \"status\": \""+status+"\"\n" +
                "  }";
    }
}
