import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWait extends Base {

    @BeforeTest
    void initialize() {
        driver = initializeDriver();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }

    @Test
    void testElementBeClickable() {
        WebElement btnEnable = driver.findElement(By.id("enable-button"));
        btnEnable.click();
        WebElement btnTest = driver.findElement(By.id("disable"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnTest));
        System.out.println("Hello World!");
    }

    @Test
    void testVisibilityDF() {
        WebElement btnDisplay = driver.findElement(By.id("display-other-button"));
        btnDisplay.click();
        WebElement btnTest = driver.findElement(By.id("hidden"));
        WebDriverWait wait = new WebDriverWait(driver, 11);
        wait.until(ExpectedConditions.visibilityOf(btnTest));
        btnTest.click();
    }

    @Test
    void elementToBeSelected() {
        WebElement btnEnable = driver.findElement(By.id("checkbox"));
        btnEnable.click();
        WebElement checkbox = driver.findElement(By.id("ch"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        System.out.println("Hello World!");
    }

    @Test
    void testTextToBePresent() {
        WebElement btnChangeText = driver.findElement(By.id("populate-text"));
        btnChangeText.click();
        WebElement lblDynamic = driver.findElement(By.id("h2"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(lblDynamic, "Selenium Webdriver"));
        System.out.println("Hello World!");
    }

    @Test
    void testAlertPresent() {
        WebElement btnEnable = driver.findElement(By.id("alert"));
        btnEnable.click();
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println("Hello World!");
    }

    @AfterTest
    void close() {
        driver.close();
    }
}
