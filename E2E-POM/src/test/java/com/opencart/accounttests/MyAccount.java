package com.opencart.accounttests;

import com.dataprovider.LoginDataProvider;
import com.dataprovider.SignUpDataProvider;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.opencart.Base;
import com.opencart.common.AccountCommons;
import com.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class MyAccount extends Base {
    private AccountCommons accountCommons;
    private MyAccountPO myAccountPage;
    private WishListPO wishListPage;
    private EditAccountInfoFormPO editAccountInfoFormPage;
    private OrderHistoryPO orderHistoryPage;
    private NewsletterPO newsletterPage;
    private MainPO mainPage;

    @BeforeTest(alwaysRun = true)
    public void initialize(){
        driver = initializeDriver();
        accountCommons= new AccountCommons(driver);
        mainPage = new MainPO(driver);
        myAccountPage = new MyAccountPO(driver);

    }

    @BeforeMethod()
    public void beforeMethod(){
        accountCommons.login(LoginDataProvider.USER_NAME,LoginDataProvider.USER_PWD);
        mainPage.goToMyAccount();
    }

    @Test
    public void testAccountElements(){
        Assert.assertTrue(myAccountPage.lblYourStoreIsDisplayed());
        Assert.assertTrue(myAccountPage.linkEditAccountIsDisplayed());
        Assert.assertTrue(myAccountPage.linkChangePasswordIsDisplayed());
        Assert.assertTrue(myAccountPage.linkModifyAdressBookIsDisplayed());
        Assert.assertTrue(myAccountPage.linkModifyWishlistIsDisplayed());
    }

    @Test
    public void testEmptyWishList(){
        wishListPage=new WishListPO(driver);
        myAccountPage.clickOnWishList();
        Assert.assertTrue(wishListPage.lblWishListEmptyIsDisplayed());
    }

    @Test(dataProvider = "edit valid info", dataProviderClass = SignUpDataProvider.class)
    public void testEditSuccesMessage(String firstname, String lastname, String phone){
        editAccountInfoFormPage= new EditAccountInfoFormPO(driver);
        myAccountPage.clickOnEditInformation();
        editAccountInfoFormPage.fillForm(firstname,lastname,phone);
        //Validaciones
        Assert.assertTrue(myAccountPage.lblYourStoreIsDisplayed());
        Assert.assertTrue(myAccountPage.linkEditAccountIsDisplayed());
        Assert.assertTrue(myAccountPage.lblSuccesEditIsDisplayed());
    }

    @Test(dataProvider = "missing at email info edit",dataProviderClass = SignUpDataProvider.class)
    public void testEditMissingAtEmailMessage(String email){
        editAccountInfoFormPage = new EditAccountInfoFormPO(driver);

        myAccountPage.clickOnEditInformation();
        editAccountInfoFormPage.changeEmail(email);
        //Message displayed  @
    }

    @Test(dataProvider = "missing dot com info edit",dataProviderClass = SignUpDataProvider.class)
    public void testEditMissingDotComEmailMessage(String email){
        editAccountInfoFormPage = new EditAccountInfoFormPO(driver);

        myAccountPage.clickOnEditInformation();
        editAccountInfoFormPage.changeEmail(email);
        Assert.assertTrue(editAccountInfoFormPage.lblErrorWrongEmailIsDisplayed());
    }

    @Test
    public void testEmptyOrderHistory(){
        orderHistoryPage=new OrderHistoryPO(driver);
        myAccountPage.clickOnOrderHistory();
        Assert.assertTrue(orderHistoryPage.lblEmptyOrderHistoryIsDisplayed());
    }

    @Test
    public void testNewsletterSubscription(){
        newsletterPage= new NewsletterPO(driver);
        myAccountPage.clickOnNesletter();
        newsletterPage.changeNeswletter();
        Assert.assertTrue(myAccountPage.lblSuccessNewsLetterIsDisplayed());
    }

    @AfterMethod
    public void afterMethod(){
        mainPage.logout();
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
