package lessonSixteenRequestMethodsTest;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected final int  SUCCESS_STATUS_CODE = 200;
    protected RequestSpecification baseRequestSpec;

    @BeforeMethod
    public void beforeMethod(){
        baseRequestSpec = given()
                .log().body()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON);
    }

}
