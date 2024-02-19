
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LessonSeventeenTest extends BaseTest{
    @DataProvider
    public Object[][] Expressions() {
        return new String[][] {
                {"3 + 9 + 0", "12"},
                {"5 - 5 + 9", "9"},
                {"2 * 2", "4"},
                {"6 / 3", "2"},
        };
    }

    @Test(dataProvider = "Expressions")
    public void checkBaseOperations(String expression, String expectedResult) {
        String actualResult = mainPage.enterExpression(expression).getResult();
        Assert.assertEquals(expectedResult, actualResult);
    }
}