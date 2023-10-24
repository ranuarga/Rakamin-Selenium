Feature: Cart
  @Positive
  Scenario: User put item on cart
    Given User open the Products page
    And User click Add to cart button
    When User click Shopping Cart button
    Then Item is in Your Cart page