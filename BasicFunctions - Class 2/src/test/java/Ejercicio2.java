import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio2 extends Base {


    @BeforeTest
    void initialize() {
        driver = initializeDriver();
        driver.get("https://demoqa.com/buttons");

    }

    @Test
    void testExercise2() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions act = new Actions(driver);

        WebElement dblClickBtn = driver.findElement(By.id("doubleClickBtn"));
        act.doubleClick(dblClickBtn).perform();
        WebElement dblClickMsg = driver.findElement(By.id("doubleClickMessage"));
        wait.until(ExpectedConditions.visibilityOf(dblClickMsg));
        Assert.assertTrue(dblClickMsg.getText().contains("You have done a double click"));

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        act.contextClick(rightClickBtn).perform();
        WebElement rightClickMsg = driver.findElement(By.id("rightClickMessage"));
        wait.until(ExpectedConditions.visibilityOf(rightClickMsg));
        Assert.assertTrue(rightClickMsg.getText().contains("You have done a right click"));

        List<WebElement> clickBtns = driver.findElements(By.xpath("//button[contains(text(),\"Click Me\")]"));
        WebElement singleClickBtn = clickBtns.get(2);
        singleClickBtn.click();
        WebElement singleClickMsg = driver.findElement(By.id("dynamicClickMessage"));
        wait.until(ExpectedConditions.visibilityOf(singleClickMsg));
        Assert.assertTrue(singleClickMsg.getText().contains("You have done a dynamic click"));

    }

    @AfterTest
    void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
