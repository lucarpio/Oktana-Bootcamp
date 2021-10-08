import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample5 extends Base{
    @BeforeTest(alwaysRun = true)
    void initialize() {
        driver = initializeDriver();
    }

    @Test(dependsOnMethods = "testExample5_3")
    void testExample5_1() {
        driver.get("https://www.google.com");
        System.out.println("abrimos google");
    }

    @Test(dependsOnMethods = "testExample5_1")
    void testExample5_2() {
        driver.get("https://www.linkedin.com");
        System.out.println("abrimos linkedin");
    }

    @Test
    void testExample5_3() {
        driver.get("https://www.salesforce.com");
        System.out.println("abrimos salesforce");
    }

    @AfterTest(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }
}
