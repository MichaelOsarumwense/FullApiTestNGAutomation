package DataDrivenTest;
import java.time.LocalDate;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Datadriventest_AddNewEMployee {
    // prepare test data in excel
    //prepare xl utilty file
    // write test ng test with data provider method

    @Test (dataProvider = "empdataprovider")
    void postNewEmployee(String eid, String etitle,String eauthor) {

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type","application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id",eid);
        requestParams.put("title",etitle);
        requestParams.put("author",eauthor);

        httpRequest.body(requestParams.toJSONString());

        Response response =  httpRequest.post("http://localhost:3000/posts");

        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 201);


        // capture response body
         String responseBody = response.getBody().asString();
         System.out.println("Response body is:" + responseBody);
         Assert.assertEquals(responseBody.contains(etitle),true);
    }

    @DataProvider (name="empdataprovider")
    Object[][] getEmpData() throws IOException
    {
        //Read data from excel
        String path =System.getProperty("user.dir")+"/src/test/java/DataDrivenTest/empdata.xlsx";
        int rownum=XLUtils.getRowCount(path, "sheet1");
        int colcount=XLUtils.getCellCount(path, "sheet1",1);

        String empData [][] =new String[rownum][colcount];

        for (int i =1; i <= rownum; i++) {
            for (int j =0; j < colcount; j++) {
                empData[i - 1][j] =XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        //String empData [] []= { {"1km", "103", "abm"}, {"2d", "400f", "594"}, {"qr13", "8009", "6mr"}};
        return (empData);
    }

}
