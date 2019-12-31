package ApiAutomationPack;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_Post_Request {


    @Test
    void RegistrationSuccessful(){
        //specify base url
        RestAssured.baseURI="http://restapi.demoqa.com/customer";

        //Request object creator
        RequestSpecification httpRequest = RestAssured.given();

        //Request Payload sending along with post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName","Johj");
        requestParams.put("LastName","XYkn");
        requestParams.put("UserName","JoZ");
        requestParams.put("Password","JohanXkkk");
        requestParams.put("Email","JohoooiZ@gmail.com");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.POST,"/register");


        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 201);

        //success code validation
        String successCode=response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");
    }

}
