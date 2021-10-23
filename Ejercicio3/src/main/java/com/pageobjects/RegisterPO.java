package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPO {

    private final WebDriver driver;

    @FindBy(id = "id_gender2")
    private WebElement radioGenderF;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastnameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dayPicker;

    @FindBy(id = "months")
    private WebElement monthPicker;

    @FindBy(id = "years")
    private WebElement yearPicker;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement statePicker;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "id_country")
    private WebElement countryPicker;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "submitAccount")
    private WebElement registerBtn;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String name, String lastname,
                             String password, String dayBd,
                             String monthDb, String yearBd,
                             String address, String city,
                             String state, String postcode,
                             String country, String phone) {
        radioGenderF.click();

        if (name != null) {
            firstNameInput.sendKeys(name);
        }

        if (lastname != null) {
            lastnameInput.sendKeys(lastname);
        }

        if (password != null) {
            passwordInput.sendKeys(password);
        }

        if (dayBd != null) {
            Select daySelect = new Select(dayPicker);
            daySelect.selectByValue(dayBd);
        }

        if (monthDb != null) {
            Select monthSelect = new Select(monthPicker);
            monthSelect.selectByValue(monthDb);
        }

        if (yearBd != null) {
            Select yearSelect = new Select(yearPicker);
            yearSelect.selectByValue(yearBd);
        }

        if (address != null) {
            addressInput.sendKeys(address);
        }

        if (city != null) {
            cityInput.sendKeys(city);
        }

        if (state != null) {
            Select stateSelect = new Select(statePicker);
            stateSelect.selectByVisibleText(state);
        }

        if (postcode != null) {
            postcodeInput.sendKeys(postcode);
        }

        if (country != null) {
            Select countrySelect = new Select(countryPicker);
            countrySelect.selectByVisibleText(country);
        }

        if (phone != null) {
            mobilePhoneInput.sendKeys(phone);
        }

        registerBtn.click();
    }
}
