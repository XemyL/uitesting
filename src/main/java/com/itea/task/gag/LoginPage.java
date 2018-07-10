package com.itea.task.gag;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    @FindBy(id = "login-email-name")
    private WebElement loginInput;

    @FindBy(id = "login-email-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//form[@id='login-email']//input[@type='submit']")
    private WebElement submitButton;

    public void enterCredentials(String login, String password){
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
