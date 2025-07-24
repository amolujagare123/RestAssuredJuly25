package GoRest;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.GoRest.GoRestCreateUser.getGoRestPayload;

public class CreateUserPayloadDataProvider3 {


    @Test (dataProvider = "getData")
    public void createUserTest(String name,String email,String gender,String status) {

        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(getGoRestPayload(name,email,gender,status))
                .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);
    }


    @DataProvider
    Object[][] getData() throws IOException {


        // 1. read the file
        FileInputStream fileInputStream = new FileInputStream("Data/UserTestData.xlsx");

        // 2. convert the file object into Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 3. convert the file object into Workbook
        XSSFSheet sheet = workbook.getSheet("Sheet2");

        // 4. count active rows
        int rowCount = sheet.getPhysicalNumberOfRows();

       // 5. find col count
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for (int j=0;j<colCount;j++)
                data[i][j] =  row.getCell(j).toString();


        }


        return data;
    }

}
