package lessonSixteenRequestMethodsTest;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import org.aston.lessonSixteen.Person;


public class BaseTest {
    protected final int  SUCCESS_STATUS_CODE = 200;
    Person tom = new Person("Tom", "Salesforce developer");

    RequestSpecification baseRequestSpec = given()
                                            .log().body()
                                            .baseUri("https://postman-echo.com")
                                            .contentType(ContentType.JSON);
}
