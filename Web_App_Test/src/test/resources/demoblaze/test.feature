Feature: Go to web: https://www.demoblaze.com/
  Sign up an user.
  Login and logout with the user signed up.
  Add a laptop to the cart.
  Check the laptop was added to cart.

  @signup
  Scenario: signup in page
    Given user is on homepage
    When user navigate to signup
    And user enters username and password in signup
    Then success signup message is displayed

  @login
  Scenario: login in homepage
    Given user is on homepage
    When user navigate to login
    And user enters username and password in login
    Then success login message is displayed
    When Add a laptop to the cart
    Then Check the laptop was added to cart