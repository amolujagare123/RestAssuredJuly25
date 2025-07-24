package GoRest;

import io.restassured.RestAssured;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.GoRest.GoRestCreateUser.getGoRestPayload;

public class CreateUserPayloadDataProvider2 {


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
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count active rows
        int rowCount = sheet.getPhysicalNumberOfRows();

       // 5. find col count
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

            for (int j=0;j<colCount;j++)
                data[i][j] =  row.getCell(j).toString();

           /* data[i][0] =  row.getCell(0).toString();
            data[i][1] =  row.getCell(1).toString();
            data[i][2] =  row.getCell(2).toString();;
            data[i][3] =  row.getCell(3).toString();;*/
        }

        /*data[0][0] = "Ravi Kumar";
        data[0][1] = "ravi.kumar@example.com";
        data[0][2] = "male";
        data[0][3] = "active";

        data[1][0] = "Sneha Patil";
        data[1][1] = "sneha.patil@example.com";
        data[1][2] = "female";
        data[1][3] = "inactive";

        data[2][0] = "Amit Sharma";
        data[2][1] = "amit.sharma@example.com";
        data[2][2] = "male";
        data[2][3] = "active";*/

        return data;
    }

}
