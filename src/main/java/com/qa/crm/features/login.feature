Feature: Test Login Feature 

	
Scenario: Verify Login with valid Credentials 
	Given user is on login page 
	When user enter valid "batchautomation" and "Test@12345" 
	And click on login button 
	Then user navigate to home page 
	
	
Scenario Outline: Verify Login with Invalid Credentials 
	Given user is on login page 
	When user enter invalid <username> and <password> 
	And click on login button 
	Then user not navigate to home page 
	
	Examples: 
		| username        | password   |
		| 		          | test123    |
		| rupalik         |            |
		| rupalik         | Test@12345 |
		| batchautomation |  abcd      |
	
