Feature: Login and buying a product

  Scenario Outline: user can login to the app and buy a product successfully
    Given app opened successfully to home screen
    When  click on side menu in home page
    And click on login button in side menu
    And select the existing user in login screen
    And click on login button in login screen
    Then user should be directed to home screen
    When click on the first product in home screen
    And click on add to cart button in first product screen
    And click on the cart button in first product screen
    And click on proceed to checkout in cart screen
    And enter full name "<name>" in full name field in checkout screen
    And enter address "<address>" in address line field in checkout screen
    And enter city "<city>" in city field in checkout screen
    And enter zip coe "<code>" in zip code field in checkout screen
    And  enter country "<country>" in country field in checkout screen
    And click on to payment button in checkout screen
    And enter card holder name "<card holder name>" in card holder name field in  payment screen
    And enter card number "<card number>" in card number field in payment screen
    And enter card expiery date "<date>" in expiery date field in  payment screen
    And enter security code "<security code>" in security code in  payment screen
    And click on review order button in paymnet screen
    And click on proceed to checkout in review your order screen
    Then success message "<message>" in completed order screen
    Examples:
      | name  | address | city  | code   | country | card holder name | card number | date  | security code | message           |  |
      | alyaa | Giza    | haram | 283945 | Egypt   | alyaa mohamed    | 12345678910 | 02\25 | 123           | Checkout Complete |  |





