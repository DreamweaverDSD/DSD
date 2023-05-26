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

### Main Page

**19-User Guide Button:**
- Expected - The button is expteced to take the user to the User Guide Page and view the guide's text
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



### Test case Data page:

#### Button Test

**23-Get Data List Button:**
- Expected - GUI gets data information from data database
- Result - Button not working as expected, occasionaly leading to crashes or returning the user to the main activity page. Needs to be connected with the API

**24-Discard Data Button:**
- Expected - GUI send delete request to delete data entry from Database
- Result - Button not working as expected, occasionaly leading to crashes or returning the user to the main activity page. Needs to be connected with the API

**25-Change Data Label Button:**
- Expected - GUI sends a request to alter the label of a data entry to the data database with a new label value
- Result - Button not working as expected, occasionaly leading to crashes or returning the user to the main activity page. Needs to be connected with the API

**26-Back Button:**
- Expected - GUI sends the user back to the main menu
- Result - The button takes the user to the main menu


### Test case Prediction Model page: 

#### Button Test

**27-Show Model Info Button:**
- Expected - GUI tries to get the prediction model's information from the server.
- Result - The button is not working as expected, crashing the application. Needs to be connected with the API

**28-Reset Model Button:**
- Expected - GUI sends the user to the reset model window ???
- Result - The button takes the user to the reset model window

**29-Predict User Motion Button:**
- Expected - GUI sends the user to the window where the prediction graph will be displayed
- Result - The button takes the user to the window where the prediction graph will be displayed

**30-Back Button:**
- Expected - GUI sends the user back to the main menu
- Result - The button takes the user to the main activity


### Test case Reset Prediction Model page: 

#### Button Test

**31-Submit Button:**
- Expected - The request button to reset the user's prediction model is sent to the server
- Result - Pressing the button invokes no response. Needs to be connected with the API.

**32-Back Button:**
- Expected - GUI sends the user back to the Prediction Model window
- Result - The button takes the user to the Prediction Model window


### Test case Prediction Graph page: 

#### Button Test

**33-Return Button:**
- Expected - GUI sends the user back to the Prediction Model window
- Result - The button takes the user to the Prediction Model window

**34-End Button:**
- Expected - Stops the device from requesting prediction data and sends the user back to the Prediction Model window
- Result - The button successfully takes the user to the Prediction Model window. Needs to be connected with API in order to add the remaining behaviour


### Test case Equipment Page

#### Button Test

**35-Bind a equipment button:**
- Expected - Expected to send the user to the connect to equipment page
- Result - Sends the user to the connect to equipment page

**36-Connect button:**
- Expected -  Expected to connect successfully with the equipment with the respectve IP adress
- Result - The integration with server-side is still not working, so it isn't connecting yet

**37-Back button:**
- Expected -  Expected to send the user back to the Equipment page
- Result - Sends te user to the equipment page.

**38-Get equipment information button:**
- Expected -  Expected to send the user to the equipment information page
- Result - Sends the user to the information page

**39-Back button:**
- Expected -  Expected send the user back to the equipment page
- Result - Sends the user to the equipment page

**40-Get equipment status button:**
- Expected -  Expected to send the user to the equipment status page
- Result - Sends the user back to the main page

**41-Collect Data button:**
- Expected -  Expected to send the user to the collect data page
- Result - Sends the user back to the collect data page

**42-Start button:**
- Expected -  Expected to start collecting the data depending on the option of type of data
- Result - The Integration with the server-side is still not working, so it isn't connecting yet

**43-End button:**
- Expected -  Expected to end collecting the type of data that was being collected
- Result - The integration with the server-side is still not working, so it isn't connecting yet

**44-Back button:**
- Expected -  Expected to send the user to the equipment page
- Result - Sends the user back to the Equipment page

**45-Unbind equipment button:**
- Expected -  Expected to send the user to the Unbind page
- Result - Sends the user to the Unbind page

**46-Submit button:**
- Expected -  Expected to Unbind the equipment currently connected
- Result - Cannot unbind, because there is no equipment connected beforehand and needs to be connected to server

**47-Back button:**
- Expected -  Expected to send the user to the Equipment page
- Result - Sends the user back to the Equipment page

**48-Back To main menu button:**
- Expected -  Expected to send the user back to the mainpage
- Result - Sends the user back to the main page

#### Input Test

**49-IP adress inputs:**
- Expected -  Expected accept 1 byte individually and verify if the range is valid (0-255)
- Result - Verifyies all restrictions

**50-Port input:**
- Expected -  Expected accept valid port number (0-65535)
- Result - Verifyies if the port is valid or not

**51-Type of data collected radio button:**
- Expected -  Expected to be selected when user interacts with it
- Result - It is selected when interacted

### Test case User Guide Page

#### Button Test

**52-Back to main menu button:**
- Expected -  Expected to send the user back to the main page
- Result - Sends the user back to the main page


| Test Case No. | Module |                                                                              Result                                   | Corresponding Requirement |
| :-----------: | :----: | :---------------------------------------------------------------------------------------------------------------------------------------------------------: | :-----------------------: |
|       1       | Android|                                    Failed - The textbox should accept both letters and numbers but only accepts numbers         |1|
|       2       | Android|                                                                              Passed                                             |1|
|       3       | Android|                                                                       Test not conducted                                        |1|
|       4       | Android|                                                                              Passed                                             |1|
|       5       | Android|                                                                              Passed                                             |3|
|       6       | Android|                                                                              Passed                                             |3|
|       7       | Android|                                                                              Passed                                             |3|
|       8       | Android|                                                                              Passed                                             |3|
|       9       | Android|                                                                              Passed                                             |3|
|       10      | Android|                                                                              Passed                                             |3|
|       11      | Android|                                                                       Test not conducted                                        |3|
|       12      | Android|                                                                              Passed                                             |3|
|       13      | Android|                                                                              Passed                                             |5|
|       14      | Android|                                                                       Test not conducted                                        |5.1|
|       15      | Android|                                                                              Passed                                             |5.2|
|       16      | Android|                                                                              Passed                                             |5.2, 5.2.1|
|       17      | Android|                                                                       Test not conducted                                        |5.2, 5.2.1|
|       18      | Android|                                                                              Passed                                             |5.2, 5.2.1|
|       19      | Android|                                                                              Passed                                             |7|
|       20      | Android|                                                                              Passed                                             |6|
|       21      | Android|                                                                              Passed                                             | |
|       22      | Android|                                                                              Passed                                             |8|              
|       23      | Android| Failed - Button not working as expected, occasionaly leading to crashes or returning the user to the main activity page. Needs to be connected with the API |10.2|
|       24      | Android| Failed - Button not working as expected, occasionaly leading to crashes or returning the user to the main activity page. Needs to be connected with the API |10.3|
|       25      | Android| Failed - Button not working as expected, occasionaly leading to crashes or returning the user to the main activity page. Needs to be connected with the API |10.4|
|       26      | Android|                                                                              Passed                                              ||
|       27      | Android|                            Failed - The button is not working as expected, crashing the application. Needs to be connected with the API |9.5|
|       28      | Android|                                                                              Passed                                              |8.1|
|       29      | Android|                                                                              Passed                                              |9.4|
|       30      | Android|                                                                              Passed                                              ||
|       31      | Android|                                     Failed - Pressing the button invokes no response. Needs to be connected with the API.        |8.1|
|       32      | Android|                                                                              Passed                                              ||
|       33      | Android|                                                                              Passed                                              ||
|       34      | Android|    Failed - The button successfully takes the user to the Prediction Model window. Needs to be connected with API in order to add the remaining behaviour   ||    
|       35      | Android|                                                                              Passed                                              |6.1|
|       36      | Android|    Failed - The integration with server-side is still not working, so it isn't connecting                                        |6.1|
|       37      | Android|                                                                              Passed                                              ||
|       38      | Android|                                                                              Passed                                              |6.2|
|       39      | Android|                                                                              Passed                                              ||
|       40      | Android|    Failed - Sends the user back to the main page                                                                                 |6.4|
|       41      | Android|                                                                              Passed                                              |6.5|
|       42      | Android|    Failed - The Integration with the server-side is still not working, so it isn't connecting yet                                |6.5|
|       43      | Android|    Faled - The integration with the server-side is still not working, so it isn't connecting yet                                 |6.5|
|       44      | Android|                                                                               Passed                                             ||
|       45      | Android|                                                                                Passed                                            |6.3|
|       46      | Android|    Failed - Cannot unbind, because there is no equipment connected beforehand and needs to be connected to server                |6.3|
|       47      | Android|                                                                                 Passed                                           ||
|       48      | Android|                                                                                 Passed                                           ||
|       49      | Android|                                                                                 Passed                                           |6.1|
|       50      | Android|                                                                                 Passed                                           |6.1|
|       51      | Android|                                                                                 Passed                                           |6.5|
|       52      | Android|                                                                                 Passed                                           ||                       


## 3. Conclusion:

-  For this iteration of testing, were tested the UI components with random clicks to get feedback from each one of them, to see how they would react and what type of input and interaction restrictions exists.
-  It was tested the flow of the pages as well during the use of the app, where each page leads to depending on the button that is pressed and if the exceptions are displayed as expected to the user in case of doing something wrong when interacting. The speed of transition between pages was also an important factor.  
-  For testing the app and during all the time of the app testing, the app never crashed, giving good results for performance and interaction feedback. 
-  Accessibility in each page (colors contrast, background images, etc…) might be improved. 
-  As overall report from the testers of the mobile module, the application seems to work perfectly with stable and efficient responses. 
-  Get Equipment Status, Get data list, Discard data and change label of data buttons are not working as they should be. Sometimes causes the application to crash or doing something that is not supposed to do. 

