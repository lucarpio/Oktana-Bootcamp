package com.ejercicio3;

import com.opencart.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Solucion extends Base {

    @BeforeTest
    public void beforeTest() {
        driver = initializeDriver();
        driver.get("automationpractice.com");
    }

    @Test
    public void testRegister() {

        WebElement btnLogin = driver.findElement(By.className("login"));
        btnLogin.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement emailInput = driver.findElement(By.id("email_create"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys("sofiacarpio@email.com");

        WebElement btnRegister = driver.findElement(By.id("SubmitCreate"));
        btnRegister.click();

        WebElement registerTitle = driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1"));
        wait.until(ExpectedConditions.textToBePresentInElement(registerTitle, "Create an account"));

        WebElement radioGenderF = driver.findElement(By.id("id_gender2"));
        radioGenderF.click();

        WebElement firstnameInput = driver.findElement(By.id("customer_firstname"));
        firstnameInput.sendKeys("Sofia");

        WebElement lastnameInput = driver.findElement(By.id("customer_lastname"));
        lastnameInput.sendKeys("Carpio");

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("Password123");

        WebElement dayPicker = driver.findElement(By.id("days"));
        Select daysSelect = new Select(dayPicker);
        daysSelect.selectByValue("1");

        WebElement monthPicker = driver.findElement(By.id("months"));
        Select monthsSelect = new Select(monthPicker);
        monthsSelect.selectByValue("2");

        WebElement yearPicker = driver.findElement(By.id("months"));
        Select yearsSelect = new Select(yearPicker);
        yearsSelect.selectByValue("1995");

        WebElement addressInput = driver.findElement(By.id("address1"));
        addressInput.sendKeys("331 Long Branch Rd");

        WebElement cityInput = driver.findElement(By.id("city"));
        cityInput.sendKeys("Gatlinburg");

        WebElement statePicker = driver.findElement(By.id("id_state"));
        Select stateSelect = new Select(statePicker);
        stateSelect.selectByVisibleText("Tennessee");

        WebElement postcodeInput = driver.findElement(By.id("postcode"));
        postcodeInput.sendKeys("37738");

        WebElement countryPicker = driver.findElement(By.id("id_country"));
        Select countrySelect = new Select(countryPicker);
        countrySelect.selectByVisibleText("United States");

        WebElement mobilePhoneInput = driver.findElement(By.id("phone_mobile"));
        mobilePhoneInput.sendKeys("987654321");

        WebElement registerBtn = driver.findElement(By.id("submitAccount"));
        registerBtn.click();

        WebElement loginEmailInput = driver.findElement(By.id("email"));
        loginEmailInput.sendKeys("sofiacarpio@email.com");

        WebElement loginPwdInput = driver.findElement(By.id("passwd"));
        loginPwdInput.sendKeys("Password123");

        WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
        loginBtn.click();


        //Punto 3
        WebElement womenTab = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
        womenTab.click();

        List<WebElement> detailView = driver.findElements(By.xpath("//a[@title=\"View\"]"));
        detailView.get(0).click();

        WebElement productDescription = driver.findElement(By.id("short_description_content"));
        String productDescriptionContent = productDescription.getText();

        WebElement productPrice = driver.findElement(By.id("our_price_display"));
        String productPriceContent = productPrice.getText();

        System.out.println("Product desc: " + productDescriptionContent + "\nProduct price: " + productPriceContent);

        WebElement productQuantity = driver.findElement(By.id("quantity_wanted"));
        productQuantity.clear();
        productQuantity.sendKeys("" + Math.random() * 5 + 1);

        List<WebElement> detailImages = driver.findElements(By.xpath("//li[contains(@id,\"thumbnail_\")]"));
        int detailImagesQty = detailImages.size();
        Assert.assertEquals(detailImagesQty, 3);

        WebElement productSizes = driver.findElement(By.id("group_1"));
        Select productSizeSelector = new Select(productSizes);
        productSizeSelector.selectByVisibleText("L");

        WebElement continueShoppingBtn = driver.findElement(By.xpath("//span[contains(.,\"Continue\") and contains(@class,\"btn\")]"));
        continueShoppingBtn.click();


    }

    @Test
    public void ejercicioTarea3() {

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
