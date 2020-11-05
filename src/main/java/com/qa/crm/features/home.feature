Feature: Test Menu on home page 

Background: Open CRM site 
	Given user is on login page 
	When user enter valid "batchautomation" and "Test@12345"
	And click on login button on home page
	
	
#Scenario: Verify the menu list on home page 
#	Given user navigate to home page 
#	When user check menu on home page 

	
	
Scenario: Verify Logout link on home page 
	Given user is on home page 
#	When user click on logout link on home page 
#	Then user is on login page 
	
 