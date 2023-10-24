Feature: User Information in Checkout
  @Positive
  Scenario: User input User Information in Checkout page
    Given User in the "Checkout: Your Information" page
    And User input First Name
    And User input Last Name
    And User input Zip/Postal Code
    When User click continue button
    Then User redirected to Checkout: Overview page