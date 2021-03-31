@file
Feature: Duplicate Lead in LeafTaps Application

Scenario Outline: TC04_To valiate Duplicate Lead functionality

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
When Click On email in Find by section
Given Enter the email id as <emailId>
When Click Find Leads link
When Cick the Resultin lead displayed with the respective mailid
Then View leads page should be displayed
When Click Duplicate Lead button
Then Verify that the Duplicate Lead page is displayed
When Click on create lead button in duplicate Lead page
Then View leads page should be displayed
Then Verify whether the DuplicatedLeadFirstName is same as OriginalLeadFirstName

Examples:
|username|password|emailId|
|'Demosalesmanager'|'crmsfa'|'DemoLeadA@DemoLeadA.com'|