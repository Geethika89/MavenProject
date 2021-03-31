@file
Feature: Merge Lead in LeafTaps Application

Scenario Outline: TC03_To valiate Merge Lead functionality

#Given Open Chrome Browser
#And Load the application url

And Enter the username as <username>
And Enter the password as <password>
When Click login button
Then Homapage should be displayed
When Click crmsfa Link
Then My Homepage should be displayed
When Click Leads link
Then  My Leads page should be displayed

When  Click Merge Leads link
Then Merge Leads page should be displayed
When  Click the icon near 'From Lead' input box
When Validate if we can switch to new window
Then New Find Leads window should be displayed
When Click a Lead from the lead list
And Navigate back to parent window
Then Merge Leads page should be displayed
When Click the icon near 'To Lead' input box
When Validate if we can switch to new window
Then New Find Leads window should be displayed
When Click a Reulting To Lead
When Navigate back to parent window
When Click Merge button
When Click Ok in Alert
Then View leads page should be displayed
When Click Find Leads link
Then Find Leads page should be displayed
Given Enter Lead Id
When Click Find Leads button
Then verify the text message displayed after succesfull Merge

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
