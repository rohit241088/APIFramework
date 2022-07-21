Feature: Update user Feature test
  Scenario Outline: Trying to check if API send correct response if valid data is sent
    Given User is trying to update user details
    When call the Register api with name "<name>" and job "<job>" and user "<user>"
    Then Update user status code should be "<statuscode>"
    Examples:
      |name|job|statuscode|user|
      |morpheus|zion resident|200|2|
      |rohit|ds|240|22|