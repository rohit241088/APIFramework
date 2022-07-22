package base;

import RequestBuilder.Request;
import RequestBuilder.RequestBody;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import requestClassPojo.BaseRequest;
import utils.PropertiesHelper;

import java.lang.reflect.Field;
import java.util.Iterator;

public class ApiCall extends Request {
    private RequestBody<BaseRequest> body=null;

    private Request request=null;
   public String clsName=null;
   private Response response;
   private Scenario sc;


public ApiCall(Scenario sc){
    this.sc=sc;
     request=new Request();

}


public<T extends BaseRequest> void setRequestClass(Class<T>cls){
    body=new RequestBody(cls);

}
public RequestBody body(){
    return body;
}
public void addHeader(String name,String value){
    requestSpecification=requestSpecification.header(name,value);
}
    public void addQueryParameter(String name,Object value){
        requestSpecification=requestSpecification.queryParam(name,value);
    }
    public void addPath(String name,String value){
        requestSpecification=requestSpecification.pathParam(name,value);
    }
    public Response callAPI(String apiName) {

        Iterator<Object> iterator=configHelper.returnPro().keySet().iterator();
        while(iterator.hasNext()){
            String k=(String)iterator.next();
            if(apiName.contains(k)){
                apiName=k;
            }
        }
        this.clsName=apiName;
           String endPointValue = (String) super.configHelper.getValue(apiName);
        String apiMethodType = endPointValue.split("@@@")[0];
        String apiEndPoint = endPointValue.split("@@@")[1];
        sc.log("EndPoint is "+apiEndPoint);
         this.hitApi(apiEndPoint,apiMethodType);
        return  response;
    }

    private void logAllBodyValues(){
    if(body.returnRequestBodyObject()!=null){
        Field[] fields=body.returnRequestBodyObject().getClass().getDeclaredFields();
        for(Field field:fields){
            try {
                sc.log(body.returnRequestBodyObject().getClass().getSimpleName()+
                        " field name "+field.getName()+
                        " value is "+(String) field.get(body.returnRequestBodyObject()));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }
    private void hitApi(String apiEndPoint,String apiMethodType){
        switch (apiMethodType) {
            case "get": case "Get":

                response = requestSpecification.when().get(apiEndPoint);
                break;
            case "post": case "Post":
                if (body.returnRequestBodyObject()==null){

                    response = requestSpecification.when().post(apiEndPoint);
                }
                else{
                    this.logAllBodyValues();
                    response = requestSpecification.body(body.returnRequestBodyObject()).when().post(apiEndPoint);
                }
                break;
            case "put": case "Put":
                if (body.returnRequestBodyObject()==null){
                    response = requestSpecification.when().put(apiEndPoint);
                }
                else{
                    this.logAllBodyValues();
                    response = requestSpecification.body(body.returnRequestBodyObject()).when().put(apiEndPoint);
                }
                break;
        }
    }
    public Response callAPI(String apiName,String current,String tobeReplaced) {

        Iterator<Object> iterator=configHelper.returnPro().keySet().iterator();
        while(iterator.hasNext()){
            String k=(String)iterator.next();
            if(apiName.contains(k)){
                apiName=k;
            }
        }
        this.clsName=apiName;
        String endPointValue = (String) super.configHelper.getValue(apiName);
        String apiMethodType = endPointValue.split("@@@")[0];
        String apiEndPoint = endPointValue.split("@@@")[1].replace(current,tobeReplaced);
         this.hitApi(apiEndPoint,apiMethodType);
        return  response;
    }

public Response getResponse(){
          return  response;
}

}
