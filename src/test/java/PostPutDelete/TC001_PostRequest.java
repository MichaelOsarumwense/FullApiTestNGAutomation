package PostPutDelete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_PostRequest {
//cmd for installing Json server /json dd (npm install -g json-server)
// cmd for staring Json server (json-server --watch db.json)

    @Test
     public void Test1(){

    RequestSpecification httpRequest = RestAssured.given();

    httpRequest.header("Content-Type","application/json");

    JSONObject requestParams = new JSONObject();
        requestParams.put("id","41");
         requestParams.put("title","Billionaire Master");
        requestParams.put("author","Michael Osa");
        requestParams.put("ice","Tea");

        httpRequest.body(requestParams.toJSONString());

        Response response =  httpRequest.post("http://localhost:3000/posts");

        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 201);


}
}
