package PostPutDelete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_DeleteRequest {

    @Test
    public void Test2(){

        RequestSpecification httpRequest = RestAssured.given();

        Response response =  httpRequest.delete("http://localhost:3000/posts/20");

        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);


    }

}
