import org.testng.annotations.*;

public class TestNgAnnotations extends Base {
    @Test
    void testCase1() {
        System.out.println("test case 1");
    }

    @Test
    void testCase2() {
        System.out.println("test case 2");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("afterMethod");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    void afterClass() {
        System.out.println("afterClass");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("beforeTest");
    }

    @AfterTest
    void afterTest() {
        System.out.println("afterTest");
    }

    @BeforeSuite
    void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("afterSuite");
    }
}
