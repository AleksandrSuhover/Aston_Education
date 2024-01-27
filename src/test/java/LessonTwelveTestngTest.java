import org.aston.lesson_12_testng.LessonTwelveTestng;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LessonTwelveTestngTest {


    @DataProvider
    public Object[][] factorialNumbers() {
        return new Object[][]{
                {1 ,1},
                {1, 0},
                {1, -1},
                {120, 5}
        };
    }

    @Test(dataProvider = "factorialNumbers")
    void testGetFactorialNumber(int expectedValue, int transmittedNum){
        Assert.assertEquals(expectedValue, LessonTwelveTestng.getFactorialNumber(transmittedNum));
    }
}
