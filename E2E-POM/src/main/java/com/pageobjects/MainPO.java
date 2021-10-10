package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPO {
    private final WebDriver driver;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement btnMyAccount;

    @FindBy(xpath = "//a[contains(.,'Login')]")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement btnRegister;


    final String url = "https://demo.opencart.com";

    public MainPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {
        return url;
    }

    public void clickOnRegister() {
        btnMyAccount.click();
        btnRegister.click();
    }

}
