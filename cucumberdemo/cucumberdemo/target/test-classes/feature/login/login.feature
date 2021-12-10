
Feature: Validate Facebook login with valid Credintial and also InavalidCredintial


 
@Smoke
Scenario: Verify Login With Valid Credintial

    When user enters right username  and right password  and click on login button
		And Home button Should be Displyed on Home Page

@Retesting
Scenario: Verify Login With Invalid Credintial
			
			 When user enters wrong username  and wrong password  and click on login button
			 Then Home button Should'nt be Displyed on Home Page
			
