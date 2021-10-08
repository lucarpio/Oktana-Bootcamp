import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample4 extends Base{
    @BeforeTest(alwaysRun = true)
    void initialize() {
        driver = initializeDriver();
    }

    @Test(groups = {"work","salesforce"})
    void testExample4_1() {
        driver.get("https://www.google.com");
        System.out.println("abrimos google");
    }

    @Test(groups = {"work","hire"})
    void testExample4_2() {
        driver.get("https://www.linkedin.com");
        System.out.println("abrimos linkedin");
    }

    @Test(groups = {"crm","salesforce"})
    void testExample4_3() {
        driver.get("https://www.salesforce.com");
        System.out.println("abrimos salesforce");
    }


    @AfterTest(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }
}
