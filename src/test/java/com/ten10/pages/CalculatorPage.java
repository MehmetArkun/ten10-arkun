package com.ten10.pages;

import com.ten10.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalculatorPage {

    public CalculatorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//a[@data-value='Daily']")
    public WebElement DailyDuration;

    @FindBy(xpath="//a[@data-value='Monthly']")
    public WebElement MonthlyDuration;

    @FindBy(xpath="//a[@data-value='Yearly']")
    public WebElement YearlyDuration;

    @FindBy (xpath="//input[@id='proceed-button']")
    public WebElement cookiesAcceptButton;

    @FindBy(xpath="//button[@id='dropdownMenuButton']")
    public WebElement interestRateDropdown;

    @FindBy(xpath="//input[@id='rate-5%']")
    public WebElement predefinedInterestRate;

    @FindBy(xpath="//input[@id='customRange1']")
    public WebElement slider;

    @FindBy(xpath="//button[@onclick='calculateInterest()']")
    public WebElement calculateButton;

    @FindBy(xpath="//input[@id='gridCheck1']")
    public WebElement consentCheck;

    @FindBy(xpath="//h2[@id='totalAmount']")
    public WebElement calculatedAmount;

    @FindBy(xpath="//h3[@id='interestAmount']")
    public WebElement calculatedInterest;

    @FindBy(xpath="//div[@id='durationList']")
    public List<WebElement> listOfDurations;












}
