package com.dataprovider;

import com.opencart.utilities.StringFunctions;
import org.testng.annotations.DataProvider;

public class SignUpDataProvider {

    int n = 15;

    @DataProvider(name = "valid data")
    Object[][] validData() {
        return new Object[][]{
                {"henry", "jimenez", StringFunctions.randomEmail(n), "123456", "password123", "password123"}
        };
    }

    @DataProvider(name = "missing fields")
    Object[][] missingField() {
        return new Object[][]{
                {null, "jimenez", StringFunctions.randomEmail(n), "123456", "password123", "password123"},
                {"henry", null, StringFunctions.randomEmail(n), "123456", "password123", "password123"},
                {"henry", "jimenez", null, "123456", "password123", "password123"},
                {"henry", "jimenez", StringFunctions.randomEmail(n), null, "password123", "password123"},
                {"henry", "jimenez", StringFunctions.randomEmail(n), "123456", null, "password123"},
                {"henry", "jimenez", StringFunctions.randomEmail(n), "123456", "password123", null}
        };
    }

    @DataProvider(name = "missing at")
    Object[][] missingAt() {
        return new Object[][]{
                {"henry", "jimenez", "miMail.com", "123456", "password123", "password123"},
                {"jorge", "chavez", "test123", "654321", "password123", "password123"},
                {"john", "doe", "testGmail.com", "987654", "password123", "password123"}
        };
    }

    @DataProvider(name = "email missing dot com")
    Object[][] emailMissingDotCom() {
        return new Object[][]{
                {"henry", "jimenez", "test_123@test", "123456", "password123", "password123"},
                {"jorge", "chavez", "miMail@outlook", "654321", "password123", "password123"},
                {"john", "doe", "jdoe@gmail", "987654", "password123", "password123"}
        };
    }

    @DataProvider(name = "different passwords")
    Object[][] differentPasswords() {
        return new Object[][]{
                {"henry", "jimenez", StringFunctions.randomEmail(n), "123456", "password123", "password321"},
                {"jorge", "chavez", StringFunctions.randomEmail(n), "654321", "password123", "pwd123"},
                {"john", "doe", StringFunctions.randomEmail(n), "987654", "password123", "notAPassword"}
        };
    }

    @DataProvider(name = "edit valid info")
    public Object[][] editValidInfo() {
        return new Object[][]{
                {"jorge", "perez", "12347"},
                {"juan", "torres", "99999"},
                {"camilo", "quispe", "22222"},
        };
    }

    @DataProvider(name="missing at email info edit")
    public Object[][] editEmailMissingAt() {
        return new Object[][]{
                {"test.com"}
        };
    }

    @DataProvider(name="missing dot com info edit")
    public Object[][] editEmailMissingDotCom() {
        return new Object[][]{
                {"test@gmailcom"}
        };
    }
}
