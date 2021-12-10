Feature: Validate Send friend Req

Scenario: Verify Login With Valid Credintial

   		 When user enters right username  and right password  and click on login button
		And Home button Should be Displyed on Home Page

 
 

@Regression
  Scenario Outline: 
   
   Given  On Home Page have search Box Click on it
   When   Search People or Place "<SearchName>" and Click on Search button then Click on result
   Then Click on people Bt
   And Click on send friend request button
  
  Examples:
  
  |SearchName|
  |Sudha     |
  |Asha	     |
	
  
  		
  
  
