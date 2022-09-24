Feature: Login feature of PHP Travels page

  @valid
  Scenario: Login to Admin Page
    Given Enter the valid Admin credentials
      | Username | admin@phptravels.com |
      | pwd      | demoadmin            |
    Then Validating the Home page
      | cow   |
      | horse |

  @valids
  Scenario Outline: Valids logins credentials
    Given Enter the "<Username>" and "<pwd>" credentials

    Examples: 
      | Username             | pwd       |
      | admin@gmail.com      | asdf      |
      |                      | asdfaf    |
      | asdfa@gmail.com      |           |
      | admin@phptravels.com | demoadmin |
