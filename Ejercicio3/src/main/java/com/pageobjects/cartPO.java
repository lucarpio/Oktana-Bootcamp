package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPO {

    private final WebDriver driver;

    @FindBy

    @FindBy(id = "total_product")
    private WebElement totalPrice;

    public cartPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
