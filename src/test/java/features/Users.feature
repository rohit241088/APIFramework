Feature: Get all users feature test
  Scenario Outline: Trying to check if API send correct response if valid data is sent
    Given User is trying to get all users
    When call the  api with page  and pagevalue="<pagevalue>"
    Then Users list api status code should be "<statuscode>"
    Examples:
      |pagevalue|statuscode|
      |2|200|
      |23|200|