Feature: As a product owner, I want to build a responsive interest calculator web application

  Background: The user logins successfully
    Given The user logins successfully


  Scenario: Durations for interest calculation
    Given User selects a duration for interest calculation Monthly
    Then The user should see the monthly is selected
    Given The user selects daily duration for interest calculation
    Then The user should see the daily is selected
    Given User selects a duration for interest calculation Yearly
    Then The user should see the yearly is selected


  Scenario: User should be able to input the principal amount.
    Given User enters a principal amount of "1000"
    Then User should see the principal amount is displayed correctly


  Scenario: Users should be able to select the interest rate from a predefined list of rates up to 15%.
    Given User clicks on the interest rate dropdown
    And User clicks on the desired interest rate
    Then The user should see the selected interest rate is displayed


  Scenario: The application should calculate the correct interest based on the selected duration, principal amount, and interest rate.
    Given User selects a duration for interest calculation: "Yearly"
    And User selects a principal amount of "1000"
    And User enters an interest rate of "5%"
    When User clicks on the calculate button
    Then The user should see the interest amount is calculated correctly
    Then The user should see the calculated interest amount and total amounts are displayed


  Scenario: For simplicity, the calculated interest and total amount should be rounded to two decimal places.
    Given User selects a duration for interest calculation: "Daily"
    And User selects a principal amount as "6300"
    And User enters an interest rate of "6%"
    When User clicks on the calculate button
    Then User should see that the actual interest amount is rounded to two decimal places


  Scenario: All input fields (principal amount, interest rate, duration and consent) should be mandatory
    When User enters all the fields except interest rate and sees error message after calculating
    When User enters all the fields except the principal amount and sees error message after calculating
    When User enters all the fields but does not click the consent check and sees error message after calculating
















