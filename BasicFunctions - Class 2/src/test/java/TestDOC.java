import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ListsMethods;
import utilities.Miscellaneous;
import utilities.RandomEmail;

import java.util.List;

public class TestDOC extends Base {
    @BeforeTest
    void initialize() {
        driver = initializeDriver();
        driver.get("https://demo.opencart.com");
    }

    @Test
    void testFindElementBy() throws InterruptedException {

        WebElement desktops = driver.findElement(By.linkText("Desktops"));
        Miscellaneous.highLighterMethod(driver, desktops);
        Thread.sleep(3000);

        WebElement shopping = driver.findElement(By.partialLinkText("Shopping"));
        Miscellaneous.highLighterMethod(driver, shopping);
        Thread.sleep(3000);

        WebElement macImage = driver.findElement(By.xpath(""));
        Miscellaneous.highLighterMethod(driver, macImage);
        Thread.sleep(3000);

        WebElement components = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(3) > a"));
        Miscellaneous.highLighterMethod(driver, components);
        Thread.sleep(3000);

        driver.get("https://demo.opencart.com/index.php?route=account/register");
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        Miscellaneous.highLighterMethod(driver, firstNameInput);
        Thread.sleep(3000);

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        Miscellaneous.highLighterMethod(driver, lastNameInput);
        Thread.sleep(3000);

    }

    @Test
    void testListElementsBy() {
        List<WebElement> dropdownElements = driver.findElements(By.className("dropdown-toggle"));
        ListsMethods.printListText(dropdownElements);

        List<WebElement> imgElements = driver.findElements(By.className("price"));
        ListsMethods.printListText(imgElements);
    }

    @Test
    void testElementAttributes() {
        String link;
        String src;

        WebElement software = driver.findElement(By.linkText("Software"));
        link = software.getAttribute("href");
        System.out.println(link);

        WebElement imgIphone = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/a/img"));
        src = imgIphone.getAttribute("alt");
        System.out.println(src);
    }

    @Test
    void testForm() throws InterruptedException {
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("first name test");
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("last name test");
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        emailInput.sendKeys(RandomEmail.randomEmail());
        WebElement telephoneInput = driver.findElement(By.id("input-telephone"));
        telephoneInput.sendKeys("912345678");
        WebElement pwdInput = driver.findElement(By.name("password"));
        pwdInput.sendKeys("test1234");
        WebElement pwd2Input = driver.findElement(By.name("confirm"));
        pwd2Input.sendKeys("test1234");

        List<WebElement> radioBtns = driver.findElements(By.name("newsletter"));
        radioBtns.get(1).click();
        Thread.sleep(2000);
        WebElement privacyCheckBox = driver.findElement(By.name("agree"));
        privacyCheckBox.click();
        WebElement continueBtn = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        continueBtn.click();
        Thread.sleep(4000);
    }

    @AfterTest
    void closeDriver() {
        driver.close();
    }

}
