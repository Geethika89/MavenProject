@file
Feature: Edit Lead in LeafTaps Application

#Background:
#Given Open Chrome Browser
#And Load the application url

Scenario Outline: TC02_To valiate Edit Lead functionality

And Enter the username as <username>
And Enter the password as <password>
When Click login button
Then Homapage should be displayed
When Click crmsfa Link
Then My Homepage should be displayed
When Click Leads link
Then  My Leads page should be displayed

When  Click Find Leads link
Then  Find Leads page should be displayed
When Click phone tab under Find by section
Given Enter the phone number as <phoneNum>
When Click Find Leads button
Then The correspondig Leads List should be displayed with phone number 
When Click the first displayed Lead
Then  View leads page should be displayed
Then Get the old Company Name
When Click Edit button
Then  Edit Lead page should be displayed
When Replace the Company Name as <newCompanyName>
When Click Update button
Then Updated View leads page should be displayed
When Valiadte the updated company name is updated to <newCompanyName>


Examples:
|username|password|phoneNum|newCompanyName|
|'Demosalesmanager'|'crmsfa'|'99'|'TCS'|



