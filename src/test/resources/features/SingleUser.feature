Feature: Get user feature test
  Scenario Outline: Trying to check if API send correct response if valid data is sent
    Given User is trying to Getuser details
    When call the Get single get user api with user "<user>"
    Then get user status code should be "<statuscode>"
    Examples:
      |user|statuscode|
      |2|200|
      |23|404|