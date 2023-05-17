# <p align="center" >Testing Documentation</p>

## Method Explanation
With the ever-growing complexity of mobile applications and the need for fast and reliable software delivery, automated testing has become an integral part of the software development process. It enables developers to identify and rectify bugs and other issues more rapidly, thus improving the overall quality of the application. This document aims to outline our approach to automated testing for an Android application using a robust, built-in Android tool called Monkey. 
Monkey is an automated testing tool provided by the Android SDK (Software Development Kit). It generates pseudo-random streams of user events such as touches, gestures, or system-level events, which are then used to stress-test the application in ways a real user could potentially use it. By simulating various random actions, Monkey can expose obscure or unexpected behavior in the application. 
The strength of Monkey testing lies in its ability to mimic unpredictable user behavior and identify hard-to-find bugs. This tool is not aimed at specific use-cases or user scenarios, but rather the broader stability and robustness of the application under test. As such, it complements other testing methodologies like unit, integration, and user acceptance testing. 
Throughout this document, we will discuss the installation and setup process, how to run tests using Monkey, interpreting test results, and best practices when applying Monkey testing to your Android application. While Monkey testing can seem chaotic due to its random nature, when used correctly, it can significantly contribute to the overall quality and reliability of your application. 


1.Setting up the automated testing tool environment 

We will be using the ADB (android debug bridge) that will allow us to communicate with the emulator and send the respective random events. 

1.1-Download the Android SDK Platform Tools ZIP file for Windows. 

1.2-Extract the contents of this ZIP file into another folder (Like C:\platform-tools). 

1.3-Go to the directory of the extracted folder (by the name of platform-tools) and click on it. After that press Shift+right-click and choose the option “Open command window here” or” Open Poweshell window here”. 

1.4-Enter the command: adb devices 

  __Note: if this command doesn’t work on your machine, try.\adb instead of adb__ 

1.5-To start injecting commands to the android emulator, enter this command: 
.\adb shell monkey -p packagename -v numberofevents 

This are the basics filtering options that monkey provides, however, to make the interaction with the UI more efficient depending on the tester purposes, there are more filtering and restricting options available. 
Here are some of them:
<Insert images here after>

 Test case Login  

Input test: 

	__Username TextBox:__  

Expected – The textbox is expected to accept both numbers and letters  

 Result – The textbox only accepts numbers 
  
	__Password TextBox:__ 
