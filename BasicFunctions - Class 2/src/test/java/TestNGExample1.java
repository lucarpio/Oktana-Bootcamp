import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample1 extends Base {
    @BeforeTest
    void initialize() {
        driver = initializeDriver();
    }

    @Test
    void testExample1_1() {
        driver.get("https://www.google.com");
        System.out.println("abrimos google");
    }

    @Test
    void testExample1_2() {
        driver.get("https://www.sony.com");
        System.out.println("abrimos sony");
    }

    @AfterTest
    void close() {
        driver.quit();
    }
}
