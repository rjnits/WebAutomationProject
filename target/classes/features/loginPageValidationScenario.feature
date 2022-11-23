Feature: Verify login page with for different scenarios 

Background: opening the web page 
	Given user open the web page url on browser 
	
Scenario: Admin creating user with valid username, valid fullname and valid password 
	When user enter valid username "rajudas" on login page 
	When user enter valid full name "Raju Das" on login page 
	When user enter valid password "Rajudas123$$$" on login page 
	When user clicks on login button on login page 
	Then application display message "Status: user rajudas was created" on login page 
#	
Scenario: user login to application with empty username, valid fullname and valid password 
	When user enter empty username on login page 
	When user enter valid full name "Raju Das" on login page 
	When user enter valid password "Rajudas123$$$" on login page 
	When user clicks on login button on login page 
	Then application display message "Status: Login cannot be empty" on login page 
	
Scenario: user login to application with valid username, empty fullname and valid password 
	When user enter valid username "rajudas" on login page 
	When user enter empty full name on login page 
	When user enter valid password "Rajudas123$$$" on login page 
	When user clicks on login button on login page 
	Then application display message "Status: Full name cannot be empty" on login page 
	
Scenario: user login to application with valid username, valid fullname and empty password 
	When user enter valid username "rajudas" on login page 
	When user enter valid full name "Raju Das" on login page 
	When user enter empty password on login page 
	When user clicks on login button on login page 
	Then application display message "Status: Password cannot be empty" on login page 
 
 Scenario: Admin creating user with weak password 
	When user enter valid username "rajudas" on login page 
	When user enter valid full name "Raju Das" on login page 
	When user enter valid password "123456" on login page
	When user clicks on login button on login page 
	Then application display message "Status: Password does not conform rules" on login page 
 