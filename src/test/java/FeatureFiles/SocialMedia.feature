Feature: Social Media links functionality

  Background:
    Given Navigate to site
    When Enter the username and password and click on login button
    Then User should login successfully


  Scenario: Successfully navigate to following pages
    When  User click the SocialMedia icons CurrentUrl should be displayed
      | facebookIcon   | facebook   |
      | twitterIcon    | twitter    |
      | youtubeIcon    | youtube    |
      | googlePlusIcon | google     |