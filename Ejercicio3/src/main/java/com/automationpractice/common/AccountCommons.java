package com.automationpractice.common;

import com.pageobjects.MainPO;
import org.openqa.selenium.WebDriver;

public class AccountCommons {

    private WebDriver driver;
    private MainPO mainPage;

    public AccountCommons(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPO(driver);
    }
}
