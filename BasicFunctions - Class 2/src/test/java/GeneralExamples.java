import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeneralExamples extends Base {

    @BeforeTest
    void initialize() {
        driver = initializeDriver();
    }

    @Test
    void testGet() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.get("https://stackoverflow.com");
        Thread.sleep(3000);
        driver.get("https://rpp.pe");
        Thread.sleep(3000);

    }

    @Test
    void testBackForward() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.get("https://stackoverflow.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
    }

    @Test
    void testGetCurrentUrl() {
        String url;
        driver.get("https://www.google.com");
        url = driver.getCurrentUrl();
        System.out.println(url);
    }

    @Test
    void getCurrentTitle() {
        String pageTitle;
        driver.get("https://www.google.com");
        pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    @AfterTest
    void closeDriver() {
        driver.close();
    }
}
