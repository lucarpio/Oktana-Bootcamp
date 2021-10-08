import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample3 extends Base {
    @BeforeTest
    void initialize() {
        driver = initializeDriver();
    }

    @Test(enabled = false)
    void testExample3_1() {
        driver.get("https://www.google.com");
        System.out.println("abrimos google");
    }

    @Test
    void testExample3_2() {
        driver.get("https://www.amazon.com");
        System.out.println("abrimos amazon");
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }
}
