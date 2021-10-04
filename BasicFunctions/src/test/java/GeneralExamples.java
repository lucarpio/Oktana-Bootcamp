import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeneralExamples extends Base {

    @BeforeTest
    void initialize() {}

    @Test
    public void testGetCurrentUrl(){
        String url;
        driver.get("https://www.google.com");
        url = driver.getCurrentUrl();
        System.out.println(url);
    }
    @Test
    public void getCurrentTitle(){
        String pageTitle;
        driver.get("https://www.google.com");
        pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }
}
