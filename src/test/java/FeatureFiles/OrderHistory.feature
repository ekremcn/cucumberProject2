Feature: Order History

    @E2E
  Scenario: Testing that name of the ordered item is the same as the item in the order history page
      Given Navigate to site
      When Enter the username and password and click on login button
      Then User should login successfully
      And Navigate to Dresses page
      Then Choose a random item and add it to the cart
      And Verify the total price of the product
      And Proceed to the checkout page
      When I do payment and confirm it
      Then Order confirmation message should be appeared
      Given Navigate to the My Order page
      Then The last order name in the table should be the same as the name of the ordered item