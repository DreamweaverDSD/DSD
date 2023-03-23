---

tags: \[Import-9c1a\]  
title: GUI Requirement Analyze  
created: '2023-03-19T14:49:38.646Z'  
modified: '2023-03-21T13:16:20.710

---

# GUI Requirement Analyze

Revision History:

<table><tbody><tr><td>Date</td><td>Author</td><td>Description</td></tr><tr><td>2023.3.19</td><td>Wutong Yu(Carolin)</td><td>Draw the draft of use-case diagram and write use-case specifications</td></tr><tr><td>2023.3.19</td><td>Jianling Yu(Durable)</td><td>Draw the activity diagrams</td></tr><tr><td>2023.3.21</td><td>Wutong Yu(Carolin)</td><td>Correct the use-case diagram and add more details.</td></tr></tbody></table>

## Use Cases

Case: Login

Case:Register

Case:Exit from app

Case:Log out

Case:User Information

Case:Get personal Information

Case:Set personal Information

Case:Equipment

Case:Connect to an Equipment

Case:View equipment information

Case:Unbind an equipment

Case:Get User Guide

Case:Sensor

Case:Get Sensor Information

Case:Connect to sensor

Case:Unbind a sensor

Case:Collect data

Case:Predition Model//

Case:Get the pretrained model

Case:Train Model with motion data

Case:Predict user motion

Case:Data Management

Case:Upload Data

Case:Get Data

Case:Discard Data

Case:Change the label of data

### Case Specification Mode

<table><tbody><tr><td>Use Case</td><td>&nbsp;</td></tr><tr><td>ID</td><td>&nbsp;</td></tr><tr><td>Source</td><td>&nbsp;</td></tr><tr><td>Brief Description</td><td>&nbsp;</td></tr><tr><td>Primary Actors</td><td>&nbsp;</td></tr><tr><td>Second Actors</td><td>&nbsp;</td></tr><tr><td>PreConditons</td><td>&nbsp;</td></tr><tr><td>Main Flow</td><td>&nbsp;</td></tr><tr><td>PostConditons</td><td>&nbsp;</td></tr><tr><td>Alternative Flows</td><td>&nbsp;</td></tr></tbody></table>

### Alternative Flow

<table><tbody><tr><td>Alternative Flow</td><td>&nbsp;</td></tr><tr><td>ID</td><td>&nbsp;</td></tr><tr><td>Source</td><td>&nbsp;</td></tr><tr><td>Brief Description</td><td>&nbsp;</td></tr><tr><td>Primary Actors</td><td>&nbsp;</td></tr><tr><td>Second Actors</td><td>&nbsp;</td></tr><tr><td>PreConditons</td><td>&nbsp;</td></tr><tr><td>Main Flow</td><td>&nbsp;</td></tr><tr><td>PostConditons</td><td>&nbsp;</td></tr></tbody></table>

### Use-case Diagram

![](https://s1.ax1x.com/2023/03/21/ppa3Yaq.png)

### Case:Login

![](https://s1.ax1x.com/2023/03/19/ppt9lDI.png)

<table><tbody><tr><td>Use Case</td><td>Login</td></tr><tr><td>ID</td><td>1</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Allow user to log in the app and use functions.</td></tr><tr><td>Primary Actors</td><td>Visitor</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The app is running.</td></tr><tr><td>Main Flow</td><td><p>1.User input information</p><p>2.If the user account exists</p><p>&nbsp; 2.1.If the password matches the User ID</p><p>&nbsp; &nbsp; 2.1.1.Show an successful notion</p><p>&nbsp; &nbsp; 2.1.2.Change to user mode</p></td></tr><tr><td>PostConditons</td><td>The database has the user's information.</td></tr><tr><td>Alternative Flows</td><td>UserIDnotExist, WrongPassword</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Login:UserIDnotExist</td></tr><tr><td>ID</td><td>1.1.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Inform visitor that he or she has input a User ID that not exists.</td></tr><tr><td>Primary Actors</td><td>Visitor</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>Visitor input a User ID that not exists</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 2 of the main flow</p><p>2.Inform visitor that he or she has input a User ID that not exists.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Login:WrongPassword</td></tr><tr><td>ID</td><td>1.2.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Inform visitor that he or she has input a User ID that not exists.</td></tr><tr><td>Primary Actors</td><td>Visior</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The password can't match the User ID</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 2.1. of the main flow</p><p>2.Inform visitor that he or she has input a User ID that not exists.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

### Case:Exit

![](https://s1.ax1x.com/2023/03/19/ppt9hrR.png)

<table><tbody><tr><td>Use Case</td><td>Exit from app</td></tr><tr><td>ID</td><td>2</td></tr><tr><td>Source</td><td>GUI</td></tr><tr><td>Brief Description</td><td>Exit from the app.</td></tr><tr><td>Primary Actors</td><td>Visitor, User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The app is running.</td></tr><tr><td>Main Flow</td><td><p>1.Click the Exit button</p><p>2.The app is closed.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Register

![](https://s1.ax1x.com/2023/03/19/pptCPJS.png)

<table><tbody><tr><td>Use Case</td><td>Register</td></tr><tr><td>ID</td><td>3</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Allow a visitor to create an account.</td></tr><tr><td>Primary Actors</td><td>Visitor</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The app is running.</td></tr><tr><td>Main Flow</td><td><p>1.Choose to register a new user</p><p>2.Input user ID</p><p>3.If the user ID is unique</p><p>&nbsp; 3.1.Record the user ID</p><p>4.Input the password</p><p>5.If the password is valid</p><p>&nbsp; 5.1.Record the password</p><p>6.Database record the new accoune</p><p>7.Show successful notion on screen</p></td></tr><tr><td>PostConditons</td><td>A new account added to the database</td></tr><tr><td>Alternative Flows</td><td>UserIDExist, PasswordInvalid, Cancel</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Register:UserIDExist</td></tr><tr><td>ID</td><td>3.1.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Inform the visitor that he or she input a User ID registered before.</td></tr><tr><td>Primary Actors</td><td>Visitor</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The visitor input a registered ID</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after step 3 of the main flow.</p><p>2.The app informs the visitor that he or she has input a registered ID.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Register: PasswordInvalid</td></tr><tr><td>ID</td><td>3.2.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Inform the visitor that he or she input invalid password</td></tr><tr><td>Primary Actors</td><td>Visitor</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The visitor input an invalid password</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after step 4 of the main flow.</p><p>2.The app informs the visitor that he or she has input an invalid password</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Register: Cancel</td></tr><tr><td>ID</td><td>3.3.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>A visitor cancels the account creation process</td></tr><tr><td>Primary Actors</td><td>Visitor</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>none</td></tr><tr><td>Main Flow</td><td><p>1. The alternative flow begins at any time</p><p>2. The visitor cancels account creation</p></td></tr><tr><td>PostConditons</td><td>A new account has not been created</td></tr></tbody></table>

Case: Log out  
![](https://s1.ax1x.com/2023/03/19/pptClz4.png)

<table><tbody><tr><td>Use Case</td><td>Log out</td></tr><tr><td>ID</td><td>4</td></tr><tr><td>Brief Description</td><td>User log out</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in the app.</td></tr><tr><td>Main Flow</td><td><p>1.User click the “log out” button</p><p>2.The app turn to visitor mode</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

Case :User Information  
![](https://s1.ax1x.com/2023/03/19/pptCBSe.png)

<table><tbody><tr><td>Use Case</td><td>User Information</td></tr><tr><td>ID</td><td>5</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>User choose to do something with personal information.and change to user information mode</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in.</td></tr><tr><td>Main Flow</td><td><p>1.User click the “User Information” button.</p><p>2.Jump to User Information interface</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Get personal Information

![](https://s1.ax1x.com/2023/03/19/pptCcwt.png)

<table><tbody><tr><td>Use Case</td><td>Get personal Information</td></tr><tr><td>ID</td><td>5.1.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Get the personal information set before.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User choose the “user information” button.</td></tr><tr><td>Main Flow</td><td><p>1.User choose to get personal information.</p><p>2.Get personal information from database.</p><p>3.Display personal information on the screen.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Set personal Information

![](https://s1.ax1x.com/2023/03/19/pptCffS.png)

<table><tbody><tr><td>Use Case</td><td>Set personal Information</td></tr><tr><td>ID</td><td>5.2.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Add personal information to database.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User choose the “user information” button.</td></tr><tr><td>Main Flow</td><td><p>1.User choose to set personal information.</p><p>2.User input personal information</p><p>3.If the information is valid</p><p>&nbsp; 3.1.Database save the information.</p><p>4.Display successful notion on screen.</p></td></tr><tr><td>PostConditons</td><td>New personal information has been added to database.</td></tr><tr><td>Alternative Flows</td><td>InvalidPersonalInformation</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Set personal Information:InvalidPersonalInformation</td></tr><tr><td>ID</td><td>5.2.1.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Inform user that he or she has entered invalid information.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The user has input invalid information.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after step 3 of the main flow</p><p>2.The app informed the user that he or she has input invalid information.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

### Case:Equipment

![](https://s1.ax1x.com/2023/03/19/pptCHwq.png)

<table><tbody><tr><td>Use Case</td><td>Equipment</td></tr><tr><td>ID</td><td>6</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>The user who have auxiliary walking tools choose to bind the tools with app to get better prediction.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in.</td></tr><tr><td>Main Flow</td><td><p>1.User click the equipment button.</p><p>2.Jump to equipment interface.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Connect to an Equipment

![](https://s1.ax1x.com/2023/03/19/pptP9mR.png)

<table><tbody><tr><td>Use Case</td><td>Connect to an Equipment</td></tr><tr><td>ID</td><td>6.1.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Add a new equipment</td></tr><tr><td>Primary Actors</td><td>user</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>There's a free equipment and the user is in equipment mode.</td></tr><tr><td>Main Flow</td><td><p>1.User click “Connect to an Equipment”</p><p>2.Bluetooth search for free equipment nearby</p><p>3.If there's free equipment nearby</p><p>&nbsp; 3.1.The equipment return information</p><p>4.Diaplay equipment information on the screen</p><p>5.Choose an equipment to connect</p><p>6.The equipment connect with the user</p><p>7.Show successful notion on the screen</p></td></tr><tr><td>PostConditons</td><td>A new equipment is connected to the user.</td></tr><tr><td>Alternative Flows</td><td>NoEquipmentNearby</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Connect to an Equipment:NoEquipmentNearby</td></tr><tr><td>ID</td><td>6.1.1.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Inform the user that there's no equipment nearby can be connected.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>No equipment nearby can be connected.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 2 of the main flow</p><p>2.Inform the user that there's no equipment can be connected.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

### Case:View equipment information

![](https://s1.ax1x.com/2023/03/19/pptCxl4.png)

<table><tbody><tr><td>Use Case</td><td>View equipment information</td></tr><tr><td>ID</td><td>6.2.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Show the equipment information on screen</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>At least one equipment connected to the user.</td></tr><tr><td>Main Flow</td><td><p>1.User click the “view equipment information” button.</p><p>2.Choose the equipment that the user wants to know the information.</p><p>3.Get the equipment's information from database.</p><p>4.Show the equipment information on screen.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Unbind an equipment

![](https://s1.ax1x.com/2023/03/19/pptPktK.png)

<table><tbody><tr><td>Use Case</td><td>Unbind an equipment</td></tr><tr><td>ID</td><td>6.3.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Unbind an equipment connected to the user</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>At least one equipment connected to the user.</td></tr><tr><td>Main Flow</td><td><p>1.The user choose the equipment that he or she wants to unbind</p><p>2.Send unbind information to the equipment.</p><p>3.The equipment turn to be free.</p><p>4.Delete the equipment information in database</p><p>5.Show successful notion on screen</p></td></tr><tr><td>PostConditons</td><td>The equipment is free again.</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Get User Guide

![](https://s1.ax1x.com/2023/03/19/pptPJ1g.png)

<table><tbody><tr><td>Use Case</td><td>Get User Guide</td></tr><tr><td>ID</td><td>7</td></tr><tr><td>Source</td><td>GUI (local)</td></tr><tr><td>Brief Description</td><td>User get the app's user guide</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in.&nbsp;</td></tr><tr><td>Main Flow</td><td><p>1.The user choose to ger user guide</p><p>2.Get user guide and show it on screen</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Sensor

![](https://s1.ax1x.com/2023/03/19/pptP7ge.png)

<table><tbody><tr><td>Use Case</td><td>Sensor</td></tr><tr><td>ID</td><td>8</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>The user choose to do something with sensor</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in</td></tr><tr><td>Main Flow</td><td><p>1.The user click the “sensor” button</p><p>2.Jump to sensor interface</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Get Sensor Information

![](https://s1.ax1x.com/2023/03/19/pptPqud.png)

<table><tbody><tr><td>Use Case</td><td>Get Sensor Information</td></tr><tr><td>ID</td><td>8.1.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>The user get sensor information</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The user has in sensor mode</td></tr><tr><td>Main Flow</td><td><p>1.The user choose to get sensor information</p><p>2.Get information from database</p><p>3.Show information on the screen</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Connect to sensor

![](https://s1.ax1x.com/2023/03/19/pptVKBQ.png)

<table><tbody><tr><td>Use Case</td><td>Connect to sensor</td></tr><tr><td>ID</td><td>8.2</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>The user choose connect to a new sensor.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>There're less than 6 sensors connected to the user.</td></tr><tr><td>Main Flow</td><td><p>1.The user choose to connect to sensor</p><p>2.If there are less than 6 sensors connected</p><p>&nbsp; 2.1.Bluetooth search for sensor nearby.</p><p>3.If there's a free sensor nearby</p><p>&nbsp; 3.1.The sensor return information</p><p>4.Diaplay sensor information on the screen</p><p>5.Choose a sensor to connect</p><p>6.The sensor connect with the user</p><p>7.Show successful notion on the screen</p></td></tr><tr><td>PostConditons</td><td>A new sensor is connected.</td></tr><tr><td>Alternative Flows</td><td>Already6sensor, NosensorNearby</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Connect to sensor:Already6sensor</td></tr><tr><td>ID</td><td>8.2.1.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Inform the user that there are 6 sensors connected and he or she can't connect to a new sensor.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>There are 6 sensors connected</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 2 of the main flow</p><p>2.Inform the user that he or she has already have 6 sensors connected.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Connect to sensor:NoSensorNearby</td></tr><tr><td>ID</td><td>8.2.2.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Inform the user that there's no sensor nearby can be connected.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>No sensor nearby can be connected.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 3 of the main flow</p><p>2.Inform the user that there's no sensor can be connected.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

### Case:Unbind a sensor

![](https://s1.ax1x.com/2023/03/19/pptVqKS.png)

<table><tbody><tr><td>Use Case</td><td>Unbind a sensor</td></tr><tr><td>ID</td><td>8.3</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Unbind a sensor connected to the user.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>At least one sensor connected to the user.</td></tr><tr><td>Main Flow</td><td><p>1.The user choose the sensor that he or she wants to unbind</p><p>2.Send unbind information to the sensor</p><p>3.The sensor turn to be free.</p><p>4.Delete the sensor information in database</p><p>5.Show successful notion on screen</p></td></tr><tr><td>PostConditons</td><td>The sensor is free again.</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Collect data

![](https://s1.ax1x.com/2023/03/19/pptZNGt.jpg)

<table><tbody><tr><td>Use Case</td><td>Collect data</td></tr><tr><td>ID</td><td>8.4.</td></tr><tr><td>Source</td><td>Sensor</td></tr><tr><td>Brief Description</td><td>The user start collecting data from sensor and choose whether to store the data collected.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has been changed into sensor mode, and have at least one sensor connected to the user.</td></tr><tr><td>Main Flow</td><td><p>1. User clicks CollectData</p><p>2. GUI Checks the condition of sensor</p><p>3. If the condition of sensor is normal</p><p>&nbsp; 3.1.GUI gets ready for collecting data and wait user to click start</p><p>4. User clicks start</p><p>5.If the sensor is connected</p><p>&nbsp; 5.1. GUI gets data from sensor</p><p>6. User clicks end</p><p>7. GUI stops getting data from sensor</p><p>8. Sensor returns data to GUI</p><p>9. User chooses the type of data</p><p>10. GUI marks the data</p><p>11. If the user choose to save the data&nbsp;</p><p>&nbsp; 11.1.GUI save the data locally</p><p>&nbsp; 11.2.Show successful notion</p><p>12. Else</p><p>&nbsp; 12.1.GUI discard the data.</p></td></tr><tr><td>PostConditons</td><td>GUI has saved the data, and return to sensor mode</td></tr><tr><td>Alternative Flows</td><td>SensorAbnormal, SensorDisconnected, OverTime<br>&nbsp;</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Collect data:SensorAbnormal</td></tr><tr><td>ID</td><td>8.4.1.</td></tr><tr><td>Source</td><td>sensor</td></tr><tr><td>Brief Description</td><td>Inform the user that the sensor connected is abnormal and can't start collecting data.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The sensor connected is abnormal.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 3 of the main flow</p><p>2.Inform the user that the sensor connected is abnormal</p></td></tr><tr><td>PostConditons</td><td>GUI shows mistake notion, stop collecting data and return to sensor mode.</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Collect data:SensorDisconnected</td></tr><tr><td>ID</td><td>8.4.2.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Inform the user that the sensor is disconnected.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The sensor is disconnected.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 5.1. of the main flow</p><p>2.Inform the user that the sensor is disconnected.</p></td></tr><tr><td>PostConditons</td><td>GUI shows mistake notion, stop collecting data and jump to step 8 of the main flow.</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Collect data:OverTime</td></tr><tr><td>ID</td><td>8.4.3.</td></tr><tr><td>Source</td><td>sensor</td></tr><tr><td>Brief Description</td><td>Inform the user that the collecting process is over time limitation.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The collecting process is over time limitation.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 5 of the main flow</p><p>2.Inform the user that the collecting process is over time limitation.</p></td></tr><tr><td>PostConditons</td><td>Stop collecting data and jump to step 8 of the main flow.</td></tr></tbody></table>

### Case:Predition Model

![](https://s1.ax1x.com/2023/03/19/pptZTo9.jpg)

<table><tbody><tr><td>Use Case</td><td>Predition Model</td></tr><tr><td>ID</td><td>9</td></tr><tr><td>Source</td><td>none</td></tr><tr><td>Brief Description</td><td>Change into model mode to get prediction results</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User has log in</td></tr><tr><td>Main Flow</td><td>1. User clicks Model<br>2. GUI changes into model mode<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI changes into model mode</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Get the pretrained model

![](https://s1.ax1x.com/2023/03/19/pptZXQK.jpg)

<table><tbody><tr><td>Use Case</td><td>Get the pretrained model</td></tr><tr><td>ID</td><td>9.1</td></tr><tr><td>Source</td><td>Algorithm</td></tr><tr><td>Brief Description</td><td>Get pretrained model from Algorithm DataBase</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has been changed into model mode</td></tr><tr><td>Main Flow</td><td>1. User clicks GetPreModel<br>2. GUI downloads model from Algorithm DataBase<br>3. Algorithm DataBase returns the model<br>4. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI gets the pretrained model, and GUI back into model mode</td></tr><tr><td>Alternative Flows</td><td>NoInternet<br>&nbsp;</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>Get the pretrained model:NoInternet</td></tr><tr><td>ID</td><td>9.1.1.</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>Inform the user that he or she isn't connected to the Internet.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The Internet is disconnected.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after the step 2 of the main flow</p><p>2.Inform the user that the Internet is disconnected.</p></td></tr><tr><td>PostConditons</td><td>GUI shows mistake notion and return to model mode.</td></tr></tbody></table>

### Case:Train Model with motion data

![](https://s1.ax1x.com/2023/03/19/pptekSP.jpg)

<table><tbody><tr><td>Use Case</td><td>Train Model with motion data</td></tr><tr><td>ID</td><td>9.2</td></tr><tr><td>Source</td><td>GUI( loacal)</td></tr><tr><td>Brief Description</td><td>Choose data to individualize model</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has been changed into model mode</td></tr><tr><td>Main Flow</td><td>1. User clicks Individualize model<br>2. GUI gets datalist from the collected data stored locally<br>4. GUI shows datalist<br>5. User chooses data to individualize<br>6. GUI give the chosen data to server<br>7. Data database gives the data to the pretrained model<br>8. Server individualizes model<br>9. Server gives the model to Algorithm DataBase<br>10. GUI Downloads the model<br>11. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI gets the individualized model, and GUI back into model mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI cannot connect to Internet, shows mistake notion and back to model mode<br>2.3 If no data in data database, GUI shows mistake notion and back to model mode<br>6.2 If GUI cannot connect to Internet, shows mistake notion and back to model mode<br>10.2 If GUI cannot connect to Internet, shows mistake notion and back to model mode<br>&nbsp;</td></tr></tbody></table>

### Case:Data Management

![](https://s1.ax1x.com/2023/03/19/ppteak9.jpg)

<table><tbody><tr><td>Use Case</td><td>Data Management</td></tr><tr><td>ID</td><td>10</td></tr><tr><td>Source</td><td>none</td></tr><tr><td>Brief Description</td><td>Change into data mode to manage the collected data</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User has log in</td></tr><tr><td>Main Flow</td><td>1. User clicks Data management<br>2. GUI changes into data mode<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI changes into data mode</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:Upload Data

![](https://s1.ax1x.com/2023/03/19/ppteBSx.jpg)

<table><tbody><tr><td>Use Case</td><td>Upload Data</td></tr><tr><td>ID</td><td>10.1</td></tr><tr><td>Source</td><td>GUI(local)</td></tr><tr><td>Brief Description</td><td>Upload local data through server to database</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has changed into data mode</td></tr><tr><td>Main Flow</td><td>1. User clicks upload data<br>2. GUI shows local data information<br>3. User chooses data to upload<br>4. GUI uploads data to data database<br>5. Data database saved the data<br>6. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI upload data to data database, and back into data mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If no data saved local, shows mistake notion and back to data mode<br>4.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>&nbsp;</td></tr></tbody></table>

### Case:Get Data

![](https://s1.ax1x.com/2023/03/19/ppter6K.jpg)

<table><tbody><tr><td>Use Case</td><td>Get Data</td></tr><tr><td>ID</td><td>10.2</td></tr><tr><td>Source</td><td>DataBase</td></tr><tr><td>Brief Description</td><td>Get datalist from data DataBase</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has changed into data mode</td></tr><tr><td>Main Flow</td><td>1. User clicks get data<br>2. GUI gets data information from data database<br>3. Data database returns data information<br>4. GUI shows data information<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI upload data to data database, and back into data mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>&nbsp;</td></tr></tbody></table>

### Case:Discard Data

![](https://s1.ax1x.com/2023/03/19/pptec0e.jpg)

<table><tbody><tr><td>Use Case</td><td>Discard Data</td></tr><tr><td>ID</td><td>10.3</td></tr><tr><td>Source</td><td>DataBase</td></tr><tr><td>Brief Description</td><td>Get datalist from data DataBase, and delete chosen data</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has changed into data mode</td></tr><tr><td>Main Flow</td><td>1. User clicks get data<br>2. GUI gets datalist information from data database<br>3. Data database returns datalist information<br>4. GUI shows data information<br>5. User chooses data to delete<br>6. GUI send delete request to data Database<br>7. Data database delete the data chosen<br>8. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>Discard chosen data from data database, and GUI back into data mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>3.2 If nothing on datalist, GUI shows mistake notion and back to data mode<br>5.2 If User chooses nothing or quit, GUI shows delete nothing and back to data mode<br>6.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>&nbsp;</td></tr></tbody></table>

### Case:Change the label of data

![](https://s1.ax1x.com/2023/03/19/ppteRkd.jpg)

<table><tbody><tr><td>Use Case</td><td>Change the label of data</td></tr><tr><td>ID</td><td>10.4</td></tr><tr><td>Source</td><td>DataBase</td></tr><tr><td>Brief Description</td><td>Change the label of data in database</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has changed into data mode</td></tr><tr><td>Main Flow</td><td>1. User clicks change label<br>2. GUI gets data information from data database<br>3. Data database returns data information<br>4. GUI shows data information<br>5. User chooses data to change, and chooses the new type<br>6. GUI send alter request to data database<br>7. Database update the new label of data<br>8. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI upload data to data database, and back into data mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>3.2 If nothing on datalist, GUI shows mistake notion and back to data mode<br>5.2 If User chooses nothing, or the new type is the same as the old one, or quit, GUI shows alter nothing and back to data mode<br>6.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>&nbsp;</td></tr></tbody></table>
