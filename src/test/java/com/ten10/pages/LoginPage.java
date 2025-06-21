package com.ten10.pages;

import com.ten10.utilities.ConfigurationReader;
import com.ten10.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//input[@id='UserName']")
    public WebElement userNameInput;

    @FindBy(xpath="//input[@id='Password']")
    public WebElement passwordInput;

    @FindBy(xpath="//button[@id='login-submit']")
    public WebElement loginSubmitButton;

    @FindBy (xpath="//input[@id='proceed-button']")
    public WebElement cookiesAcceptButton;



    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //cookiesAcceptButton.click();
        userNameInput.click();
        userNameInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.click();
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginSubmitButton.click();

    }
}
