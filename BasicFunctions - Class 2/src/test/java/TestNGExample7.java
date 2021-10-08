import org.testng.annotations.*;

public class TestNGExample7 extends Base {

    @Test
    @Parameters({"myName", "myAge", "suiteParameter"})
    void testExample7_1(String myName, String myAge, String suiteParameter) {
        System.out.println("test 7_1");
        System.out.println("My name is: " + myName);
        System.out.println("My age is: " + myAge);
        System.out.println(suiteParameter);
    }

    @Test
    @Parameters({"myUniversity", "myPC", "suiteParameter"})
    void testExample7_2(String myUniversity, String myPC, String suiteParameter) {
        System.out.println("test 7_2");
        System.out.println("My university is: " + myUniversity);
        System.out.println("My pc is: " + myPC);
        System.out.println(suiteParameter);
    }

    @Test(dataProvider = "getData")
    void informData(String usr, String pwd) {
        System.out.println("username: " + usr);
        System.out.println("password: " + pwd);
    }

    @DataProvider
    Object[][] getData() {
        Object[][] data = new Object[3][2];

        //1st set
        data[0][0] = "firstUsername";
        data[0][1] = "firstPassword";

        //2nd set
        data[1][0] = "secondUsername";
        data[1][1] = "secondPassword";

        //3rd set
        data[2][0] = "thirdUsername";
        data[2][1] = "thirdPassword";

        return data;

    }
}
