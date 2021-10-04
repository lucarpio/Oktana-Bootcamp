import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 extends Base {

    @BeforeTest
    void initialize() {
        driver = initializeDriver();
    }

    @Test
    void test() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(5000);
    }

    @AfterTest
    void closeDriver() {
        driver.close();
    }
}
