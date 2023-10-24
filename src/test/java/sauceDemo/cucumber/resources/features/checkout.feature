Feature: Checkout
  @Positive
  Scenario: User checkout when cart filled
    Given User open the "Checkout: Overview" page and cart already filled
    When User click finish button
    Then Redirect to Checkout: Complete! page