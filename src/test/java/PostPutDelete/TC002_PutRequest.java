package PostPutDelete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_PutRequest {

    @Test
    public void Test2(){

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type","application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id","5");
        requestParams.put("title","Michael");
        requestParams.put("author","Rich Guy");

        httpRequest.body(requestParams.toJSONString());

        Response response =  httpRequest.put("http://localhost:3000/posts/5");

        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);


    }
}
