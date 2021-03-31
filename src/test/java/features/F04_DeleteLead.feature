@file
Feature: Delete Lead in LeafTaps Application

Scenario Outline: TC05_To Validate the Delete Lead Functionality

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

When Click Find Leads Button
Then  Find Leads page should be displayed
When Click phone tab under Find by section
Given Enter the phone number for delete Lead as <phnNum>
When Click Find Leads link
When Get the lead Id and click it
Then View leads page should be displayed 
When Click the Delete button
Then  My Leads page should be displayed
When Click Find Leads Button
Given Enter Captured LeadId
When Click Find Leads link
Then verify the text message displayed after succesfull Deletion

Examples:
|username|password|phnNum|
|'demosalesmanager'|'crmsfa'|'9'|