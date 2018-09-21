Feature: Login DataSet

Background:
Given Open the Browser
And Maximize the window
And Load the URL
And Set the TimeOut

@smoke @sanity
Scenario Outline: Positive Login LeafTaps
And Enter the UserName as <username>
And Enter the Password as <password>
When Click on Login
Then Verify Login is Successful

Examples: 
|username|password|
|DemoSalesManager|crmsfa|
|DemoCSR|crmsfa|

@smoke
Scenario: Negative Login LeafTaps
And Enter the UserName as DemoSalesMana
And Enter the Password as crmsfa
When Click on Login
But Verify Login is failed