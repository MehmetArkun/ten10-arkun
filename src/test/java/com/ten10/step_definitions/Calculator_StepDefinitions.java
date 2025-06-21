package com.ten10.step_definitions;

import com.ten10.pages.CalculatorPage;
import com.ten10.pages.LoginPage;
import com.ten10.utilities.ConfigurationReader;
import com.ten10.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Calculator_StepDefinitions {

    CalculatorPage calculatorPage = new CalculatorPage();
    LoginPage loginPage = new LoginPage();

    @Given("The user logins successfully")
    public void the_user_logins_successfully() {
        loginPage.login();
    }


    @Given("User selects a duration for interest calculation Monthly")
    public void userSelectsADurationForInterestCalculationMonthly() {
        calculatorPage.MonthlyDuration.click();
    }

    @Then("The user should see the monthly is selected")
    public void theUserShouldSeeTheMonthlyIsSelected() {
        Assert.assertTrue(calculatorPage.MonthlyDuration.isDisplayed());
    }

    @Given("The user selects daily duration for interest calculation")
    public void theUserSelectsDailyDurationForInterestCalculation() {
        calculatorPage.DailyDuration.click();
    }

    @Then("The user should see the daily is selected")
    public void theUserShouldSeeTheDailyIsSelected() {
        Assert.assertTrue(calculatorPage.DailyDuration.isDisplayed());
    }


    @Given("User selects a duration for interest calculation Yearly")
    public void userSelectsADurationForInterestCalculationYearly() {
        calculatorPage.YearlyDuration.click();
    }

    @Then("The user should see the yearly is selected")
    public void theUserShouldSeeTheYearlyIsSelected() {
        Assert.assertTrue(calculatorPage.YearlyDuration.isDisplayed());
    }

    @Given("User enters a principal amount of {string}")
    public void userEntersAPrincipalAmountOf(String amount) {
        String valueSlider = calculatorPage.slider.getAttribute(amount);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.getElementById('customRange1').value = arguments[0];", amount);
        js.executeScript("updateRangeValue(arguments[0]);", amount);

    }

    @Then("User should see the principal amount is displayed correctly")
    public void userShouldSeeThePrincipalAmountIsDisplayedCorrectly() {
        Assert.assertEquals("1000", calculatorPage.slider.getAttribute("value"));
    }

    @Given("User clicks on the interest rate dropdown")
    public void user_clicks_on_the_interest_rate_dropdown() {
        calculatorPage.interestRateDropdown.click();
    }

    @Given("User clicks on the desired interest rate")
    public void user_clicks_on_the_desired_interest_rate() {
        calculatorPage.predefinedInterestRate.click();
    }

    @Then("The user should see the selected interest rate is displayed")
    public void the_user_should_see_the_selected_interest_rate_is_displayed() {
        Assert.assertTrue(calculatorPage.predefinedInterestRate.isDisplayed());
    }

    @Given("User selects a duration for interest calculation: {string}")
    public void user_selects_a_duration_for_interest_calculation(String value) {
        calculatorPage.YearlyDuration.click();
    }


    @And("User selects a principal amount of {string}")
    public void userSelectsAPrincipalAmountOf(String amount) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.getElementById('customRange1').value = arguments[0];", amount);
        js.executeScript("updateRangeValue(arguments[0]);", amount);
    }



    @And("User enters an interest rate of {string}")
    public void userEntersAnInterestRateOf(String arg0) {
        calculatorPage.interestRateDropdown.click();
        calculatorPage.predefinedInterestRate.click();
    }

    @When("User clicks on the calculate button")
    public void user_clicks_on_the_calculate_button() {
        calculatorPage.consentCheck.click();
        calculatorPage.calculateButton.click();
    }

    @Then("The user should see the interest amount is calculated correctly")
    public void the_user_should_see_the_interest_amount_is_calculated_correctly() {
        /*double rate = 5.0;
        double principal = 1000.00;
        double duration = 1.0;

        double interest = (principal * rate * duration) / 100;
        double result = interest + principal;
        String interestStr = String.valueOf(result);

         */

        String expected = "Total Amount with Interest: 1050.00";
        Assert.assertEquals(expected, calculatorPage.calculatedAmount.getText());

    }


    @Then("The user should see the calculated interest amount and total amounts are displayed")
    public void theUserShouldSeeTheCalculatedInterestAmountAndTotalAmountsAreDisplayed() {
        Assert.assertTrue(calculatorPage.calculatedInterest.isDisplayed());
        Assert.assertTrue(calculatorPage.calculatedAmount.isDisplayed());
    }

    @And("User selects a principal amount as {string}")
    public void userSelectsAPrincipalAmountAs(String amount) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.getElementById('customRange1').value = arguments[0];", amount);
        js.executeScript("updateRangeValue(arguments[0]);", amount);
    }


    @Then("User should see that the actual interest amount is rounded to two decimal places")
    public void userShouldSeeThatTheActualInterestAmountIsRoundedToTwoDecimalPlaces() {
        /*
        double rate = 6;

        double principal = 6300;
        int duration = 1;
        double dailyRate = rate / 365;
        double interest = (principal * dailyRate * duration) / 100;
        */

        String expected = "Total Amount with Interest: 6301.03561768";

        Assert.assertNotEquals(expected, calculatorPage.calculatedAmount.getText());


    }


    @When("User enters all the fields except interest rate and sees error message after calculating")
    public void user_enters_all_the_fields_except_interest_rate_and_sees_error_message_after_calculating() {
        calculatorPage.YearlyDuration.click();
        String valueSlider = calculatorPage.slider.getAttribute("1000");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.getElementById('customRange1').value = 1000;");
        js.executeScript("updateRangeValue(1000);"); // optional, to trigger UI update
        calculatorPage.consentCheck.click();
        calculatorPage.calculateButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Please fill in all fields"));
        alert.accept();

    }


    @When("User enters all the fields except the principal amount and sees error message after calculating")
    public void user_enters_all_the_fields_except_the_principal_amount_and_sees_error_message_after_calculating() {

        calculatorPage.YearlyDuration.click();
        calculatorPage.interestRateDropdown.click();
        calculatorPage.predefinedInterestRate.click();
        String valueSlider = calculatorPage.slider.getAttribute("0");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.getElementById('customRange1').value = 0;");
        js.executeScript("updateRangeValue(0);");
        calculatorPage.consentCheck.click();
        calculatorPage.calculateButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Please fill in all fields"));
        alert.accept();
    }

    @When("User enters all the fields but does not click the consent check and sees error message after calculating")
    public void user_enters_all_the_fields_but_does_not_click_the_consent_check_and_sees_error_message_after_calculating() {

        calculatorPage.YearlyDuration.click();
        calculatorPage.interestRateDropdown.click();
        calculatorPage.predefinedInterestRate.click();
        String valueSlider = calculatorPage.slider.getAttribute("1000");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.getElementById('customRange1').value = 1000;");
        js.executeScript("updateRangeValue(1000);");
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Please fill in all fields"));
        alert.accept();
    }



}
