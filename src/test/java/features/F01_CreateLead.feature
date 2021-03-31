@file
Feature: CreateLead in LeafTaps Application

#Background:
#Given Open Chrome Browser
#And Load the application url

Scenario Outline: TC01_To validate CreateLead Functionality
And Enter the username as <username>
And Enter the password as <password>
When Click login button
Then Homapage should be displayed
When Click crmsfa Link
Then My Homepage should be displayed
When Click Leads link
Then  My Leads page should be displayed
When  Click Create Lead link
Then  Create Lead page should be displayed
Given Enter the company name as <companyName>
Given Enter the first name as <firstName>
Given Enter the last name as <lastName>
When  Click create lead button
Then  View leads page should be displayed
Then Verify whether the view Lead page is displayed with given <companyName>,<firstName>,<lastName>

Examples:
|username|password|companyName|firstName|lastName|
|'Demosalesmanager'|'crmsfa'|'TCS'|'Geethika'|'Gokul'|