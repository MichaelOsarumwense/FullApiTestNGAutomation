package ApiAutomationPack;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_Get_Request  {

    @Test
    void getWeatherDetails(){
        //specify base url
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";

        //Request object creator
        RequestSpecification httpRequest = RestAssured.given();

        //Response object creator
        Response response=httpRequest.request(Method.GET,"London");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("response body is: " + responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
