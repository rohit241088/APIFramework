Feature: Login Feature test
  @Login
  Scenario Outline: Trying to check if API send correct response if valid data is sent
    Given User is trying to login
    When call the Login api with user name "<email>" and password "<password>"
    Then login status code should be "<statuscode>"
Examples:
    |email|password|statuscode|
    |eve.holt@reqres.in|cityslicka|200|
    |rohit.sharma@gmail.com|fdfdf |400|

