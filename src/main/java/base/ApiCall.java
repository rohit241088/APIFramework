package base;

import RequestBuilder.Request;
import RequestBuilder.RequestBody;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;

public class ApiCall extends Request {
    private RequestBody body=null;

    private Request request=null;
   private String clsName=null;
   private Response response;


public ApiCall(){
     request=new Request();

}


public void setRequestClass(Class<?>cls){
    body=new RequestBody(cls);
    clsName=cls.getSimpleName();
}
public RequestBody body(){
    return body;
}
public void addHeader(String name,String value){
    requestSpecification=requestSpecification.header(name,value);
}
    public void addQueryParameter(String name,String value){
        requestSpecification=requestSpecification.queryParam(name,value);
    }
    public void addPath(String name,String value){
        requestSpecification=requestSpecification.pathParam(name,value);
    }
    public void callAPI(String apiName) {
        String endPointValue = (String) super.configHelper.getValue(apiName);
        String apiMethodType = endPointValue.split("@@@")[0];
        String apiEndPoint = endPointValue.split("@@@")[1];
        switch (apiMethodType) {
            case "get": case "Get":
                response = requestSpecification.log().all().when().get(apiEndPoint);
                break;
            case "post": case "Post":
                if (body.returnRequestBodyObject()==null){
                    response = requestSpecification.log().all().when().post(apiEndPoint);
                }
                else{
                    response = requestSpecification.body(body.returnRequestBodyObject()).log().all().when().post(apiEndPoint);
                }
                break;
            case "put": case "Put":
                if (body.returnRequestBodyObject()==null){
                    response = requestSpecification.log().all().when().put(apiEndPoint);
                }
                else{
                    response = requestSpecification.body(body.returnRequestBodyObject()).log().all().when().put(apiEndPoint);
                }
                break;
        }
    }
    public void callAPI(String apiName,String current,String tobeReplaced) {
        String endPointValue = (String) super.configHelper.getValue(apiName);
        String apiMethodType = endPointValue.split("@@@")[0];
        String apiEndPoint = endPointValue.split("@@@")[1].replace(current,tobeReplaced);
        switch (apiMethodType) {
            case "get": case "Get":
                response = requestSpecification.log().all().when().get(apiEndPoint);
                break;
            case "post": case "Post":
                if (body.returnRequestBodyObject()==null){
                    response = requestSpecification.log().all().when().post(apiEndPoint);
                }
                else{
                    response = requestSpecification.body(body.returnRequestBodyObject()).log().all().when().post(apiEndPoint);
                }
                break;
            case "put": case "Put":
                if (body.returnRequestBodyObject()==null){
                    response = requestSpecification.log().all().when().put(apiEndPoint);
                }
                else{
                    response = requestSpecification.body(body.returnRequestBodyObject()).log().all().when().put(apiEndPoint);
                }
                break;
        }
    }

public Response getResponse(){
     response.then().log().all();

       return  response;
}

}
