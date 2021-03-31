
Feature: Login functionality in LeafTaps Application

#Background:
#Given Open Chrome Browser
#And Load the application url

Scenario Outline: TC001_Login with positive credential
And Enter the username as <username>
And Enter the password as <password>
When Click login button
Then Homapage should be displayed

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|

Scenario: TC002_Login with negative credential
And Enter the username as 'Demo'
And Enter the password as 'crmsfa'
When Click login button
But Error message should be displayed