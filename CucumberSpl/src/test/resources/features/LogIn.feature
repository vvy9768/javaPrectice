

Feature: varify the Flipkart pages  by cucumber
  Scenario: To varify No. of  product on page after searching the product on table 
    
    When launch the Flipkart website 
    Then cancel the login and go on search 
    And  search for a shoes 
    Then No.of Product on the Particular Searchpage  
   

Scenario: To varify search Box by Searching the shose
    When launch the Flipkart website 
    Then cancel the login and go on search 
    And  search for a shoes 
    Then close the browser  