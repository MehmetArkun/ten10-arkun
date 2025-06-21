Notes on Test Execution and Known Behaviour
You can run the framework using the CukesRunner class.

Please note that the final step of the last scenario is intentionally expected to fail, as it reflects a known bug in the application. I deliberately placed this scenario at the end of the test suite to clearly demonstrate this issue.

While implementing the test cases, I interpreted the provided requirements as acceptance criteria. However, I encountered some overlap between the following three points:

All input fields (principal amount, interest rate, duration, and consent) are mandatory.

The application should inform the user if any field is left empty or unselected.

Clear error messages should be displayed to guide users in case of missing or incorrect inputs.

The final scenario in the test suite is focused on error messaging and is designed to show the following:

All inputs are validated except the consent checkbox (whether this should be considered a required input is debatable).

The application behaves in a user-friendly manner except when the user does not check the consent box.

Clear error messages are displayed for missing inputs, except when the consent box is left unchecked—in this case, no error message is shown, which appears to be a bug.

Additionally, I observed a usability issue during testing: the application repeatedly logged me out approximately every 20–30 seconds, which persisted throughout the process.