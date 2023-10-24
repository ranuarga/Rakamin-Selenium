Feature: Login
  @Positive
  Scenario: User login using standard_user and valid password
    Given User open the login page
    And User input standard_user username
    And User input valid password
    When User click login button
    Then User authenticated and redirected to Products page

  @Negative
  Scenario: User login using standard_user and invalid password
    Given User open the login page
    And User input standard_user username
    And User input invalid password
    When User click login button
    Then Wrong credential message appear