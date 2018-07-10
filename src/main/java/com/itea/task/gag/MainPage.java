package com.itea.task.gag;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(id = "jsid-login-button")
    private WebElement loginButton;

    @FindBy(id = "jsid-visitor-function")
    private WebElement visitorBlock;

    private WebElement profileIcon;

    private WebElement logoutButton;

    @FindBy(xpath = "//a[@href='/funny']")
    private WebElement funnyCategoryTab;

    private WebElement firstTopic;

    @FindBy(xpath = "//div[@class='featured-tag']/a")
    private List<WebElement> tagList;

    public void pressLoginButton(){
        loginButton.click();
    }

    public void openFunnyCategory(){
        funnyCategoryTab.click();
    }

    public boolean isTagPresent(String tag){
        boolean flag = false;

        for (WebElement webElement: tagList)
            if (webElement.getText().equals(tag)) {
                flag = true;
                break;
            }

        return flag;
    }

    public void openFirstTopic(){
        firstTopic.click();
    }

    public void logout(){
        profileIcon.click();
        logoutButton.click();
    }

    public boolean isLoginSuccess(){
        return !visitorBlock.getAttribute("class").contains("hide");
    }

}
