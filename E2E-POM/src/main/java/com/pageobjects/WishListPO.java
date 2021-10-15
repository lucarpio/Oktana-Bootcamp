package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPO {
    private final WebDriver driver;

    @FindBy(xpath = "//p[text()='Your wish list is empty.']")
    private WebElement lblWishListEmpty;

    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement btnContinue;

    public WishListPO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean lblWishListEmptyIsDisplayed(){
        return lblWishListEmpty.isDisplayed();
    }
}
