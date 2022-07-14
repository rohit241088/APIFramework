Feature: Registration Feature test
  Scenario Outline: Trying to check if API send correct response if valid data is sent
    Given User is trying to register
    When call the Register api with user name "<email>" and password "<password>"
    Then registration status code should be "<statuscode>"
    Examples:
      |email|password|statuscode|
      |eve.holt@reqres.in|pistol|200|
      |rohit.sharma@gmail.com||400|