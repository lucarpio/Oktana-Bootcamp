import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGExample6 extends Base{

    @Test
    @Parameters({"myName","myAge","suiteParameter"})
    void testExample6_1(String myName, String myAge, String suiteParameter) {
        System.out.println("test 6_1");
        System.out.println("My name is: " + myName);
        System.out.println("My age is: " + myAge);
        System.out.println(suiteParameter);
    }

    @Test
    @Parameters({"myUniversity","myPC","suiteParameter"})
    void testExample6_2(String myUniversity, String myPC, String suiteParameter) {
        System.out.println("test 6_1");
        System.out.println("My university is: " + myUniversity);
        System.out.println("My pc is: " + myPC);
        System.out.println(suiteParameter);
    }

}
