import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample2 extends Base{
    @BeforeTest
    void initialize() {
        driver = initializeDriver();
    }

    @Test
    void testExample2_1() {
        driver.get("https://www.stackoverflow.com");
        System.out.println("abrimos stackoverflow");
    }

    @Test
    void testExample2_2() {
        driver.get("https://www.mi.com");
        System.out.println("abrimos xiaomi");
    }

    @AfterTest
    void close() {
        driver.quit();
    }
}
