Feature: user should not be able to signin with invalid credentials

  Scenario: user should not be able to signin with invalid credentials
    Given user want to open launch the url
    And click on the signin button and select login with google
    When user enters invalid credetials error should be displayed