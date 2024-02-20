import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LessonSeventeenTest extends BaseTest{

    @DataProvider
    public Object[][] dataExpression() {
        return new String[][] {
                {"3", "6", "+", "9"},
                {"15", "6", "-", "9"},
                {"10", "2", "*", "20"},
                {"100", "2", "/", "50"},
        };
    }

    @Test(dataProvider = "dataExpression", testName = "Проверка основных функций калькулятора")
    public void checkCalculateFunctions(String firstNumber, String secondNumber, String operation, String expectedResult){
        String actualResult = mainAppCalcPage.enterSpecifiedNumber(firstNumber)
                                             .clickSelectedOperation(operation)
                                             .enterSpecifiedNumber(secondNumber)
                                             .getFinalResult();
        Assert.assertEquals(actualResult, expectedResult);
    }

}