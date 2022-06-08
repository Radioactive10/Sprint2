Feature: User should able to edit the Image, change Langauage , Signin and Signup

@EditImage
Scenario Outline: user should be able to successfully edit the image
Given user should be navigated to fotor editor page
When user clicks on signin button
And user Enters valid <username> and <password> and login
Then user navigated to editor page
When user uploads image
And user should able to edit image by adjust features
And user should able to apply effects to image
And user should able to add text on image
And user should be able to add frames to image

Examples:
|username||password|
|fepy@eelraodo.com||Zxcvbnm@1|


@Language
  Scenario: user should select Japanese language successfully.
    Given I want to open the url
    And sign in to account
    Then I need to select the language

@SaveImage
Scenario Outline: user should see the guidelines and able to send request for assistance
Given navigated to fotor page
And user clicks on the signIn button
When user enters <email> and <password> and loggedin
And clicks on Help
Then switch back to homePage
And clicks on My Project
Then download edited Photo

Examples:
|email||password|
|abd46472@gmail.com||bAf46472@|

@Signup
Scenario: user should successfully SignUp
Given navigated to fotor url
When  user should click on signup link and select signup with google
And user should enter emailId and password
Then user should navigated to HomePage 