package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPO {
    private final WebDriver driver;

    @FindBy(className = "login")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[@title=\"Women\"]")
    private WebElement womenTab;

    @FindBy(xpath = "//*[contains(@title,\"shopping cart\")]")
    private WebElement shoppingCartBtn;

    public MainPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    final String url = "http://automationpractice.com";

    public String getUrl() {
        return url;
    }

    public void clickOnLogin() {
        btnLogin.click();
    }

    public void clickOnShoppingCart() {
        shoppingCartBtn.click();
    }

}
