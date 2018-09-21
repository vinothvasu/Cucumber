Feature: Login DataSet

Background:
Given Open the Browser
And Maximize the window
And Load the URL
And Set the TimeOut

Scenario: Positive Login LeafTaps
Given Enter the Credentials
|UserName|DemoSalesManager|
|Password|crmsfa|
When Click on Login
Then Verify Login is Successful
#|UserName|
#|DemoSalesManager|
#|DemoCSR|




#Scenario: Negative Login LeafTaps
#And Enter the UserName as DemoSalesMana
#And Enter the Password as crmsfa
#When Click on Login
#But Verify Login is failed