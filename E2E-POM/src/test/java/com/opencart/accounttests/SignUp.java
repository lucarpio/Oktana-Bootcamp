package com.opencart.accounttests;

import com.dataprovider.SignUpDataProvider;
import com.opencart.Base;
import com.pageobjects.MainPO;
import com.pageobjects.SignUpFormPO;
import com.pageobjects.SignUpSuccessPO;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Base {

    private MainPO mainPage;
    private SignUpFormPO signUpFormPO;
    private SignUpSuccessPO signUpSuccessPO;

    @BeforeTest
    void initialize() {
        driver = initializeDriver();
        mainPage = new MainPO(driver);
        signUpFormPO = new SignUpFormPO(driver);
    }

    @BeforeMethod
    void beforeMethod() {
        driver.get(mainPage.getUrl());
        mainPage.clickOnRegister();
    }

    @Test(dataProvider = "valid data", dataProviderClass = SignUpDataProvider.class)
    void testUserRegistrationValidData(String firsName, String lastName, String email, String phone, String pwd, String pwdConfirm) {
        signUpSuccessPO = new SignUpSuccessPO(driver);
        signUpFormPO.fillForm(firsName,lastName,email,phone,pwd,pwdConfirm);
        Assert.assertTrue(signUpSuccessPO.lblSuccessIsDisplayed());
    }

    @Test(dataProvider = "missing fields", dataProviderClass = SignUpDataProvider.class)
    void testUserRegistrationMissingField(String firsName, String lastName, String email, String phone, String pwd, String pwdConfirm) {
        signUpFormPO.fillForm(firsName,lastName,email,phone,pwd,pwdConfirm);
        Assert.assertTrue(signUpFormPO.lblErrorGeneralIsDisplayed());
    }

    @Test(dataProvider = "missing at", dataProviderClass = SignUpDataProvider.class)
    void testUserRegistrationMissingAt(String firsName, String lastName, String email, String phone, String pwd, String pwdConfirm) {
        signUpFormPO.fillForm(firsName,lastName,email,phone,pwd,pwdConfirm);
//        Message displayed : Missing @
    }

    @Test(dataProvider = "email missing dot com", dataProviderClass = SignUpDataProvider.class)
    void testUserRegistrationEmailMissingDotCom(String firsName, String lastName, String email, String phone, String pwd, String pwdConfirm) {
        signUpFormPO.fillForm(firsName,lastName,email,phone,pwd,pwdConfirm);
        Assert.assertTrue(signUpFormPO.lblErrorWrongEmailIsDisplayed());
    }

    @Test(dataProvider = "different passwords", dataProviderClass = SignUpDataProvider.class)
    void testUserRegistrationDifferentPassword(String firsName, String lastName, String email, String phone, String pwd, String pwdConfirm) {
        signUpFormPO.fillForm(firsName,lastName,email,phone,pwd,pwdConfirm);
        Assert.assertTrue(signUpFormPO.lblErrorMismatchPasswordIsDisplayed());
    }

    @AfterTest
    void closeDriver(){
        driver.close();
    }
}
