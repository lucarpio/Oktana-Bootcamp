package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
    private final WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement registerEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement registerEmailBtn;

    @FindBy(id = "email")
    private WebElement loginEmailInput;

    @FindBy(id = "passwd")
    private WebElement loginPwdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginBtn;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterBtn(String email) {
        registerEmailInput.sendKeys(email);
        registerEmailBtn.click();
    }

    public void clickOnLogin(String email, String pwd) {
        loginEmailInput.sendKeys(email);
        loginPwdInput.sendKeys(pwd);
        loginBtn.click();
    }
}
