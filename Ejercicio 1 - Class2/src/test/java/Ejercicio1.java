import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio1 extends Base {

    @BeforeTest
    void initialize() {
        driver = initializeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    void testExercise1() throws InterruptedException {

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Sofia");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Carpio");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("clsofialu@gmail.com");

        List<WebElement> genderRadio = driver.findElements(By.xpath("//*[@id=\"genterWrapper\"]//label"));
        genderRadio.get(1).click();

        WebElement mobilePhoneInput = driver.findElement(By.id("userNumber"));
        mobilePhoneInput.sendKeys("9876543210");

        WebElement birthdayInput = driver.findElement(By.id("dateOfBirthInput"));
        birthdayInput.click();

        WebElement monthSelector = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
        Select monthSelect = new Select(monthSelector);
        monthSelect.selectByVisibleText("February");

        WebElement yearSelector = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
        Select yearSelect = new Select(yearSelector);
        yearSelect.selectByVisibleText("1995");

        WebElement dayPicker = driver.findElement(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--001\"]"));
        dayPicker.click();

        List<WebElement> hobbiesRadio = driver.findElements(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]//label"));
        hobbiesRadio.get(0).click();
        hobbiesRadio.get(2).click();

        WebElement uploadPic = driver.findElement(By.id("uploadPicture"));
//        Upload local
//        uploadPic.sendKeys("C:\\Users\\scarpio\\Downloads\\Sofia.JPEG");

        WebElement addressTxtArea = driver.findElement(By.id("currentAddress"));
        addressTxtArea.sendKeys("Las Moreras 88");

        WebElement stateSelectorDropdown = driver.findElement(By.xpath("//*[@id=\"state\"]/div[1]/div[2]/div"));
        stateSelectorDropdown.click();

        List<WebElement> stateSelector = driver.findElements(By.xpath("//*[@id=\"state\"]/div[2]/div/div"));
        stateSelector.get(0).click();

        WebElement citySelectorDropdown = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[2]/div"));
        citySelectorDropdown.click();

        List<WebElement> citySelector = driver.findElements(By.xpath("//*[@id=\"city\"]/div[2]/div/div"));
        citySelector.get(0).click();

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
        wait.until(ExpectedConditions.visibilityOf(modal));
        Assert.assertTrue(modal.getText().contains("Thanks for submitting the form"));

    }

    @AfterTest
    void testClose() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
