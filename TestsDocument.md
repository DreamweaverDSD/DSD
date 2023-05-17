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

**Username TextBox:**
- Expected – The textbox is expected to accept both numbers and letters
- Result – The textbox only accepts numbers

**Password TextBox:**

[Insert testing results for password textbox]



[Rest of the test results]

## 3. Conclusion:

-  For this iteration of testing, were tested the UI components with random clicks to get feedback from each one of them, to see how they would react and what type of input and interaction restrictions exists.
-  It was tested the flow of the pages as well during the use of the app, where each page leads to depending on the button that is pressed and if the exceptions are displayed as expected to the user in case of doing something wrong when interacting. The speed of transition between pages was also an important factor.  
-  For testing the app and during all the time of the app testing, the app never crashed, giving good results for performance and interaction feedback. 
-  Accessibility in each page (colors contrast, background images, etc…) might be improved. 
-  As overall report from the testers of the mobile module, the application seems to work perfectly with stable and efficient responses. 
-  Get Equipment Status, Get data list, Discard data and change label of data buttons are not working as they should be. Sometimes causes the application to crash or doing something that is not supposed to do. 

