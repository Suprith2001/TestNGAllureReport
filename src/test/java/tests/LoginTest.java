package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void verifyLogin()
    {
        loginPage.openWebsite();
        loginPage.login("standard_user","secret_sauce");
    }

    @Test(dataProvider = "invalid")
    public void invalidLogin(String uname,String pass)
    {
        loginPage.openWebsite();
        loginPage.login(uname,pass);
        Assert.assertTrue(loginPage.isErrorMsgDisplayed());
    }

    @DataProvider(name="invalid")
    public Object[][] data()
    {
        return new Object[][]{{"suprith","raj"},{"Raju","1234"}};
    }

}
