# UI/UX Software Testing

With the ever-growing complexity of mobile applications and the need for fast and reliable software delivery, automated testing has become an integral part of the software development process. It enables developers to identify and rectify bugs and other issues more rapidly, thus improving the overall quality of the application. This document aims to outline our approach to automated testing for an Android application using a robust, built-in Android tool called Monkey.

## Introduction to Monkey

Monkey is an automated testing tool provided by the Android SDK (Software Development Kit). It generates pseudo-random streams of user events such as touches, gestures, or system-level events, which are then used to stress-test the application in ways a real user could potentially use it. By simulating various random actions, Monkey can expose obscure or unexpected behavior in the application.

The strength of Monkey testing lies in its ability to mimic unpredictable user behavior and identify hard-to-find bugs. This tool is not aimed at specific use-cases or user scenarios, but rather the broader stability and robustness of the application under test. As such, it complements other testing methodologies like unit, integration, and user acceptance testing.

Throughout this document, we will discuss the installation and setup process, how to run tests using Monkey, interpreting test results, and best practices when applying Monkey testing to your Android application. While Monkey testing can seem chaotic due to its random nature, when used correctly, it can significantly contribute to the overall quality and reliability of your application.

## 1. Setting up the automated testing tool environment

We will be using the ADB (android debug bridge) that will allow us to communicate with the emulator and send the respective random events.

- Download the Android SDK Platform Tools ZIP file for Windows.
- Extract the contents of this ZIP file into another folder (Like C:\platform-tools).
- Go to the directory of the extracted folder (by the name of platform-tools) and click on it. After that press Shift+right-click and choose the option “Open command window here” or” Open Poweshell window here”.
- Enter the command: `adb devices`
  
  _Note: if this command doesn’t work on your machine, try .\adb instead of adb_

To start injecting commands to the android emulator, enter this command:
`.\adb shell monkey -p packagename -v numberofevents`

This are the basics filtering options that monkey provides, however, to make the interaction with the UI more efficient depending on the tester purposes, there are more filtering and restricting options available.

Here are some of them:


![Filtering options](https://imgur.com/oavJsD1.png)

![Filtering options](https://imgur.com/7BvdD1m.png)

With these options, the tester can send random events and control better the flow of the app.

## 2. Results

### Test case Login

#### Input test:

**1-Username TextBox:**
- Expected – The textbox is expected to accept both numbers and letters
- Result – The textbox only accepts numbers

**2-Password TextBox:**
- Expected - The textbox is expected to accept any type of characters strings 
- Result - The textbox accepts any type of characters

#### Button test:

**3-Submit Button:**
- Expected - The button is expected to log in the user if credentials are correct or warn the user that credentials are incorrect 
- Result - The integration with API is not done, so it is not possible to test this case

**4-Register Button:**
- Expected - The button is expected to take the user to the registration page 
- Result - It takes the user to the registration page

### Test case Registration

#### Input Test:

**5-Username TextBox:**
- Expected - The textbox is expected to accept any type of character
- Result - The textbox accepts any type of character

**6-Password TextBox:**
- Expected - The texbox is expected to accept any type of character
- Result - The textbox accepts any type of characters

**7-Repeat Password Textbox:**
- Expected - The textbox is expected to accept any type of character 
- Result - The textbox accepts any type of characters

**8-Birthday Texbox:**
- Expected - The textbox is expected to accept date format strings 
- Result - The textbox accepts any type of characters

**9-Phone Number Textbox:**
- Expected - The textbox is expected to accept only numbers  
- Result - The textbox accepts only numbers

**10-Email address Textbox:**
- Exptected - The textbox is expected to accept any type of characters 
- Result - The textbox accepts any type of character

#### Button Test:

**11-Registration Button:**
- Exptected - The button is expected to verify all formats inserted in the textboxes by the user and if successfull, take the user to the app 
- Result - The integration with API is not done, so it is not possible to test this case 

**12-Cancel Button:**
- Expected - The button is expected to take the user back to the login page
- Result - The button takes the user to the login page

### Test case Main Page

#### Button Test:

**13-User Information Button:**
- Expected - The button is expteced to take the user to the User Information Page
- Result - The button takes the user to the User Information Page

**14-User Information Button Page:**
- Expected - Username,Phone Number,Birthday and email adress are exptected to be displayed in the page.
- Result - Username,Phone Number,Birthday and email adress are not being displayed, needs to be connected to the server.

**15-Set User Information Button:**
- Expected - Expected to take the user to the User Information edit page
- Result - The button succesfully took to the User Information edit page

### Test case User Information edit page:

#### Input Test
  
**16-Birthday,phone number and email adress Textbox:**
   - Expected - The birthday,phone number and email address textboxes are expected to be editable. Birthday and phone number textbox are expected to accept only numbers. Email textbox is expected to accept any type of character.
   - Result - The birthday,phone number and email address textboxes are editable. Birthday and phone number textbox only accept numbers and email textbox accepts any type of character

#### Button Test
  
**17-Commit Button:**  
- Expected - Commit button is expected to save the changes made by the user 
- Result - Commit button not working as expected. Needs to be connected with the API

**18-Cancel Button:**
- Expected - Cancel button is expected to take the user back to the User Information page
- Result - Cancel button takes the user back to the User Information page.


**19-User Guide Button:**
- Expected - The button is expteced to take the user to the User Guide Page
- Result - The button takes the user to the User Guide Page


**20-Equipment Button:**
- Expected - The button is expteced to take the user to the Equipment Page
- Result - The button takes the user to the Equipment Page

**21-Data Button:**
- Expected - The button is expteced to take the user to the Data Page
- Result - The button takes the user to the Data Page
 
**22-Model Button:**
- Expected - The button is expteced to take the user to the Model Page
- Result - The button takes the user to the Model Page



-----------

### Test case Data


[Insert testing results for password textbox]



[Rest of the test results]
| Test Case No. | Module | Result | Corresponding Requirement |
| :-----------: | :----: | :----: | :-----------------------: |
|       1       |        | Failed ||
|       2       |        | Passed ||
|       3       |        |        ||
|       4       |        | Passed ||
|       5       |        | Passed ||
|       6       |        | Passed ||
|       7       |        | Passed ||
|       8       |        | Passed ||
|       9       |        | Passed ||
|       10      |        | Passed ||
|       11      |        |        ||
|       12      |        | Passed ||
|       13      |        | Passed ||
|       14      |        |        ||
|       15      |        | Passed ||
|       16      |        | Passed ||
|       17      |        |        ||
|       18      |        | Passed ||
|       19      |        | Passed ||
|       20      |        | Passed ||
|       21      |        | Passed ||
|       22      |        | Passed ||


## 3. Conclusion:

-  For this iteration of testing, were tested the UI components with random clicks to get feedback from each one of them, to see how they would react and what type of input and interaction restrictions exists.
-  It was tested the flow of the pages as well during the use of the app, where each page leads to depending on the button that is pressed and if the exceptions are displayed as expected to the user in case of doing something wrong when interacting. The speed of transition between pages was also an important factor.  
-  For testing the app and during all the time of the app testing, the app never crashed, giving good results for performance and interaction feedback. 
-  Accessibility in each page (colors contrast, background images, etc…) might be improved. 
-  As overall report from the testers of the mobile module, the application seems to work perfectly with stable and efficient responses. 
-  Get Equipment Status, Get data list, Discard data and change label of data buttons are not working as they should be. Sometimes causes the application to crash or doing something that is not supposed to do. 

