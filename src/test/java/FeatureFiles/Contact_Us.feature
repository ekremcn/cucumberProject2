Feature: Contact us functionality

  Scenario Outline:
    Given Navigate to site
    When Enter the username and password and click on login button
    Then User should login successfully
    And Navigate to Contact_us
    When Fill out the message box "<Subject Heading>", "<Order reference>", and "<Product>"
    Then Success message should be displayed
    Examples:
      | Subject Heading  | Order reference | Product |
      | Customer service | 225343          | 1       |
      | Webmaster        | 225362          | 1       |
      | Webmaster        | 225364          | 1       |
