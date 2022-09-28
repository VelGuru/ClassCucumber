Feature: Login feature of PHP Travels page

Background: Phptavel Login page
Given Enter the valid Admin credentials
      | Username | admin@phptravels.com |
      | pwd      | demoadmin            |
      
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
	
	@Account @smoke
	Scenario: Creating Admin Account
   Then Click on Account and navigate to Admin
   And Creating new Admin user
   
   @suppliers @smoke
	Scenario: Creating suppliers Account
   Then Click on Account and navigate to suppliers
   And Creating new suppliers user