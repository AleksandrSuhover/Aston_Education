package lessonSixteenRequestMethodsTest;


import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class PostmanRequestMethodsTest extends BaseTest{
    @Test(testName = "Тестовый запрос Get")
    public void testGetRequest(){
        baseRequestSpec
                .pathParam("name", tom.getName())
                .when().get("/get?name={name}")
                .then().log()
                .body().statusCode(SUCCESS_STATUS_CODE)
                .body("args.name", equalTo(tom.getName()));
    }

    @Test(testName = "Тестовый запрос Post")
    public void testPostRequest(){
        baseRequestSpec
                .body(tom)
                .when().post("/post")
                .then().log()
                .body().statusCode(SUCCESS_STATUS_CODE)
                .body("json.name", equalTo(tom.getName()))
                .body("json.job", equalTo(tom.getJob()));
    }

    @Test(testName = "Тестовый запрос PUT")
    public void testPutRequest(){
        baseRequestSpec
                .body(tom)
                .when().put("/put")
                .then().log()
                .body().statusCode(SUCCESS_STATUS_CODE)
                .body("json.name", equalTo(tom.getName()))
                .body("json.job", equalTo(tom.getJob()));
    }

    @Test(testName = "Тестовый запрос Patch")
    public void testPatchRequest(){
        baseRequestSpec
                .body(tom)
                .when().patch("/patch")
                .then().log()
                .body().statusCode(SUCCESS_STATUS_CODE)
                .body("json.name", equalTo(tom.getName()))
                .body("json.job", equalTo(tom.getJob()));
    }

    @Test(testName = "Тестовый запрос Delete")
    public void testDeleteRequest(){
        baseRequestSpec
                .body(tom)
                .when().delete("/delete")
                .then().log()
                .body().statusCode(SUCCESS_STATUS_CODE)
                .body("json.name", equalTo(tom.getName()))
                .body("json.job", equalTo(tom.getJob()));
    }
}
