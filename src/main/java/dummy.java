import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class dummy {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "[{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"" +
                "michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"" +
                "https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\"" +
                ",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\"" +
                ",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":" +
                "\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"}," +
                "{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":" +
                "\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\"" +
                ":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"" +
                "support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}]";

        String sampleArray="\"[1,2,3]\"";
        //map json to student
        try{
            given().cookie(new Cookie.Builder("").build());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          ///  TreeNode t=mapper.createParser(sampleArray).readValueAsTree();
        //    JsonParser jsonParser=mapper.createParser(sampleArray);
              Users[] users = mapper.readValue(jsonString, Users[].class);
            JsonPath jsonResponse=new JsonPath(jsonString);
          List<LinkedHashMap> object=jsonResponse.get("data");
          List<JsonObject>jsonObjects= jsonResponse.get("data");
//RequestSpecification res=given().filter(new Filter() {
//    @Override
//    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
//        filterableRequestSpecification.filter(new Filter() {
//            @Override
//            public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
//
//            }
//        })
//    }
//}).param("fdfd","").formParam("foam", "fdf").multiPart("file",new File("C:\\Users\\rohit\\Desktop\\New Text Document.txt"));
//res.log().all().when().post("https://www.google.com").then().log().all();
//         for(LinkedHashMap obj:object){
//    if(((Integer)obj.get("id")).intValue()<10){
//        System.out.println(obj.get("first_name"));
//        System.out.println(obj.get("last_name"));
//        System.out.println(BigDecimal.valueOf((Integer) obj.get("id")).floatValue());
//      //  float myFloatValue = BigDecimal.valueOf(obj.getDouble("aDouble")).floatValue();
//
//    }
//}
           given().baseUri("https://www.google.com").filter(new Filter() {
               @Override
               public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
                   Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
                   filterableRequestSpecification.getMethod();
                   System.out.println("http"+filterableRequestSpecification.getHttpClient().toString());
                   return response;
               }
           }).when().get();

     //       System.out.println(logSpecification.everything());
                  given().when().get("https://www.google.com").then().log().all();
         JsonNode jsonNode=mapper.readTree(jsonString);

        //    System.out.println(jsonNode.get(0).get("page").textValue());
      List< Map<String, Object>> map= mapper.readValue(jsonString, new TypeReference<List<Map<String,Object>>>(){});
        //     Map<String, Object> maps= mapper.readValue(jsonString, new TypeReference<Map<String,Object>>(){});
     //  Users users=mapper.readValue(jsonString,Users.class);
//mapper.writerWithDefaultPrettyPrinter().writeValueAsString(Users[].class);
//            String value=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Users.Support());
//           String cName= mapper.createParser(jsonString).getCurrentName();
//          ArrayType arrayType= mapper.getTypeFactory().constructArrayType(Users.class);
//TypeBindings typeBindings=arrayType.getBindings();
//List<JavaType>typeParameters=typeBindings.getTypeParameters();
//            System.out.println();
//           List<Users>user= Arrays.asList(users);
//            user.forEach((s)->
//            {
//                s.getData().stream().filter(new Predicate<Users.data>() {
//                    @Override
//                    public boolean test(Users.data data) {
//                        return !data.getEmail().split("/.")[0].startsWith("f");
//                    }
//                }).forEach((y)-> System.out.println(y.getFirstName()+"\t"+y.getEmail()));
//            }
//            );
            //System.out.println(users.getData().get(0).getEmail());

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);

            System.out.println();


List<Cookie> cookies=given().body("{\"loginId\":\"+919560749491\",\"password\":\"test@1234\"}").when().get("https://2.rome.api.flipkart.com/api/4/user/authenticate").then().extract().response().detailedCookies().asList();

     Iterator<Cookie>cookieIterator=cookies.iterator();
     while(cookieIterator.hasNext()){
         Cookie cookie=cookieIterator.next();
         System.out.println("Cookie name "+cookie.getName()+ " cookie value is "+cookie.getValue());

     }

        }
//        catch (JsonParseException e) { e.printStackTrace();}
//        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }



    }
    }

    class finaldata{
    private  List<Users>anyData=null;
    @JsonAnySetter
        public void setUsers(List<Users>value){
this.anyData=value;
    }
    @JsonAnyGetter
        public List<Users> getUsers(){
        return this.anyData;
        }


    }

 class Users {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private Users.data datao=null;
    @JsonProperty("data")
    private List<Users.data> data = null;
    @JsonProperty("support")
    private Users.Support support;


    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }



    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }


    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }



    @JsonProperty("total_pages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }


    @JsonProperty("data")
    public List<Users.data> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Users.data> data) {
                  this.data = data;
    }



    @JsonProperty("support")
    public Users.Support getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(Users.Support support) {
        this.support = support;
    }


    static class data {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("email")
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("avatar")
        private String avatar;


        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }



        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }


        @JsonProperty("first_name")
        public String getFirstName() {
            return firstName;
        }

        @JsonProperty("first_name")
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }



        @JsonProperty("last_name")
        public String getLastName() {
            return lastName;
        }

        @JsonProperty("last_name")
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }


        @JsonProperty("avatar")
        public String getAvatar() {
            return avatar;
        }

        @JsonProperty("avatar")
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }






    }



    public static class Support {

        @JsonProperty("url")
        private String url;
        @JsonProperty("text")
        private String text;


        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        @JsonProperty("url")
        public void setUrl(String url) {
            this.url = url;
        }



        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }






    }

}
