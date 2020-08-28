Feature: Successfully test for Specials

  @E2E
  Scenario:Testing that shows each item in the Specials page has discount
    Given Navigate to site
    When Enter the username and password and click on login button
    Then User should login successfully
    And Navigate to Specials
    Then I should see the discount on the price