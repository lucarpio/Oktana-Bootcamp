import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestKode extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://courses.letskodeit.com/practice");
    }

    @Test
    public void testVerify(){
        String actualTitle;
        String expectedTitle1 = "Practice Page";
        String expectedTitle2 = "Title Example";

        String actualURL;
        String expectedURL1="https://courses.letskodeit.com/practice";
        String expectedURL2="https//www.google.com.pe";

        actualTitle = driver.getTitle();
        actualURL= driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedTitle1,actualTitle); // correcta
        softAssert.assertNotEquals(actualTitle,expectedTitle2); // correcto

        softAssert.assertEquals(actualURL,expectedURL1);//correcto
        softAssert.assertEquals(actualURL,expectedURL2);//falla

        System.out.println("Hola mundo");

        softAssert.assertAll();
    }

    @Test
    public void testHardAssert(){
        String actualTitle;
        String expectedTitle1 = "Practice Page";
        String expectedTitle2 = "Title Example";

        String actualURL;
        String expectedURL1="https://courses.letskodeit.com/practice";
        String expectedURL2="https//www.google.com.pe";

        actualTitle = driver.getTitle();
        actualURL= driver.getCurrentUrl();
        Assert.assertEquals(expectedTitle1,actualTitle); //correcto
        Assert.assertEquals(expectedTitle2,actualTitle); //falla

        System.out.println("Hola mundo");
    }


    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
