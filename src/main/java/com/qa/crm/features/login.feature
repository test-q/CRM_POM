Feature: Test Login Feature 


Scenario: Verify Login with valid Credentials 
	Given user is on login page 
	When user enter valid username and password
	And click on login button 
	Then user navigate to home page 