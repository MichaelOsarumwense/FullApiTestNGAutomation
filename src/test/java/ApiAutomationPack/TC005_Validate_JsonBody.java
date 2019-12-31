package ApiAutomationPack;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_Validate_JsonBody {

    @Test
    void getWeatherDetails() {
        //specify base url
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

        //Request object creator
        RequestSpecification httpRequest = RestAssured.given();

        //Response object creator
        Response response = httpRequest.request(Method.GET, "/New York");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("response body is: " + responseBody);
        Assert.assertEquals(responseBody.contains("New York"), true);
    }
    }
