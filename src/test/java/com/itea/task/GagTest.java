package com.itea.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import com.itea.task.gag.LoginPage;
import com.itea.task.gag.MainPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GagTest
{
    private static WebDriver webDriver;
//comment example
    @BeforeClass
    public static void  initDriver(){
        webDriver = new ChromeDriver();
        webDriver.get("https://9gag.com");
    }

    @Test
    public void loginTest()
    {
        MainPage mainPage = PageFactory.initElements(webDriver, MainPage.class);
        mainPage.pressLoginButton();
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.enterCredentials("stinger_22@mail.ru", "BadExample");

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("jsid-avatar")));

        assertFalse(mainPage.isLoginSuccess());
    }

    @Test
    public void tagPresenceTest()
    {
        MainPage mainPage = PageFactory.initElements(webDriver, MainPage.class);
        mainPage.openFunnyCategory();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='featured-tag']/a[contains(.,'Funny')]")));
        assertTrue(mainPage.isTagPresent("Funny"));
    }

    @AfterClass
    public static void cleanup(){
        webDriver.quit();
    }
}