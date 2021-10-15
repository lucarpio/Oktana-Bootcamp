package com.opencart.common;

import com.pageobjects.LoginFormPO;
import com.pageobjects.MainPO;
import org.openqa.selenium.WebDriver;

public class AccountCommons {
    private MainPO mainPage;
    private LoginFormPO loginFormPage;
    private WebDriver driver;

    public AccountCommons(WebDriver driver){
        this.driver=driver;
        mainPage= new MainPO(driver);
        loginFormPage= new LoginFormPO(driver);
    }

    public void login(String username, String password){
        driver.get(mainPage.getUrl());
        mainPage.clickOnLogin();
        loginFormPage.loginUser(username,password);
    }
}
