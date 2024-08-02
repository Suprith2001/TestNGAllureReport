package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement login;

    public void openWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login()
    {
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
    }

}
