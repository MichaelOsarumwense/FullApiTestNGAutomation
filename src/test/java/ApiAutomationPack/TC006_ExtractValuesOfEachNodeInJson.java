package ApiAutomationPack;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_ExtractValuesOfEachNodeInJson {
    @Test
    void getWeatherDetails() {
        //specify base url
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

        //Request object creator
        RequestSpecification httpRequest = RestAssured.given();

        //Response object creator
        Response response = httpRequest.request(Method.GET, "/New York");

        JsonPath JsPath = response.jsonPath();

        System.out.println((String) JsPath.get("City"));
        System.out.println((String) JsPath.get("Temperature"));

        Assert.assertEquals(JsPath.get("Temperature"), "-2.8 Degree celsius");

    }
}
