Feature: Login into Application

Scenario Outline: Positive test validating login
Given open chrome browser 
And Navigate to "https://www.makemytrip.com/" Site
And Click on Login link in home page to land on Secure sign in Page
When User enters <email> and <password> and logs in
Then Verify that user is succesfully logged in to application homepage.
And close browsers

Scenario Outline: flightBooking
Given user login and is on HomePage 
When User select From and To Destinagtion
And Select Departure date
And Select Traveller and Class
Then It display list of Fights availabe
