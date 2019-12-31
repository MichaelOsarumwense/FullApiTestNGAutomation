package ApiAutomationPack;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_BasicAuth {
    @Test
    void getWeatherDetails() {
        //specify base url
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

        // BasicAuth
        PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
        basicAuth.setUserName("ToolsQA");
        basicAuth.setPassword("TestPassword");
        RestAssured.authentication=basicAuth;

        //Request object creator
        RequestSpecification httpRequest = RestAssured.given();

        //Response object creator
        Response response = httpRequest.request(Method.GET, "/");

        String responseBody = response.getBody().asString();
        System.out.println("response body is: " + responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

    }
}
