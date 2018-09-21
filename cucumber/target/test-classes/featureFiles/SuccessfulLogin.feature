Feature: Login for LeapTaps

Scenario: Positive Login LeafTaps

Given Open the Browser
And Maximize the window
And Load the URL
And Set the TimeOut
And Enter the UserName as DemoSalesManager
And Enter the Password as crmsfa
When Click on Login
Then Verify Login is Successful
