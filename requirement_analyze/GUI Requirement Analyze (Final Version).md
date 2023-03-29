---
tags: \[Import-e20a\]
title: GUI Requirement Analyze
created: "2023-03-29T15:00:01.125Z"
modified: ‘2023-03-29T15:33:15.360Z’
---

# GUI Requirement Analyze

Revision History:

<table><tbody><tr><td>Date</td><td>Author</td><td>Description</td></tr><tr><td>2023.3.19</td><td>Wutong Yu(Carolin)</td><td>Draw the draft of use-case diagram and write use-case specifications</td></tr><tr><td>2023.3.19</td><td>Jianlin Yu(Durable)</td><td>Draw the activity diagrams</td></tr><tr><td>2023.3.21</td><td>Wutong Yu(Carolin)</td><td>Correct the use-case diagram and add more details.</td></tr><tr><td>2023.3.26</td><td>Wutong Yu(Carolin)</td><td>Introduction, System Context, System Capabilities, Expected Subsets, Quality Requirements, System Inputs and Outputs</td></tr><tr><td>2023.3.29</td><td>Jianlin Yu(Durable)</td><td>Modify the use-case diagram, activity dragrams and use-case specifications</td></tr><tr><td>2023.3.29</td><td>Wutong Yu(Carolin)</td><td>Add some pictures and correct some mistakes</td></tr></tbody></table>

# 1.Intended Audience and Purpose

This document is intended to provid information guiding the installation and development process, ensuring that all system requirements are met. The following entities may find the document useful:

Customer- This page will detail all of the application requirements as understood by the production team. The customer should be able to determine that their requirements will be correctly reflected in the final product through the information found on this page.

User - A prospective user will be able to use this document to identify the main functions included in the app. Furthermore, the app will have a set of system requirements before the app can be run. Details regarding these requirements can be found here.

Development Team - Details of specific requirements that the final app must include will be located here. Developers can use this document to ensure the app developed meet all the requirements.

Server Team - By reading the requirements in this document, the Server Team can gain a comprehensive understanding about the API they need to provide.

# 2.Concept of Operations

The goal is to create a user friendly app for users to collect data and get prediction results. It will allow its users to manage prosthetics and help users use them better. The application uses document box, the application page, and the jump between application pages implemented by buttons to interact with the user. For more details on the usage and capabilities of the app, you can read System capabilities.

## 2.1. System capabilities

This auxiliary interaction is a standalone program. When the user uses it, they need to log in to enjoy the services provided by the auxiliary interaction. If the user does not have an account, they need to register an account by jumping to the registration interface and when they complete registration then they can use this auxiliary interaction.

After the user logs in, they enter the interface which the user can see all the bound devices. If the user need to do something with the sensor, they can click the Equipment button and jump to the Equipment interface. When they want to add a new device, they can click the Add button and input the ID and port of the equipment they wanto to connect with, then the app will automatically connect to the equipment through server. When the above operation is completed, the user can see the newly added device on the corresponding interface. Devices that have already been added can be clicked on the corresponding button to jump to the interface of the corresponding device details, where you can view the device information. If they don't need the device anymore, they can click the “Unbind” button to unbind the device.

Users are able to collect their data after clicking the “Collect Data” button. Through the "Start Acquisition" button, the user can make the device start collecting data, at this time the interface refreshes, the "Start Acquisition" button changes to "Stop Acquisition" button. When the "Stop Acquisition " button is pressed, a new window is created asking the label of data and whether to upload the collected data.

For the collected data, users can go to the data management interface to view, delete or modify the data. What's more, when they need to predict their behaviors, they can click the “PredictionModel” button to the corresponding interface. They can train the model with their own data, reset the model and get the information about the model. There are two types of prediction. One is "PredUserMotion_Onetime" that only predict the user's motion next step, the other is "PredUserMotion_Sync" that predict the user's motion in the next period of time.

Users can view and modify personal information by going to the personal information interface through the personal information button in the menu.  Users also can view the help Information window which displays guidelines for using the interactive system.

## 2.2.System Context

Requires a system with a GUI display because all of the operations are performed through a GUI.

Android:

<table><tbody><tr><td><strong>Android Version</strong></td><td><strong>Name</strong></td><td><strong>API Level</strong></td></tr><tr><td>Android 14</td><td>U</td><td>34</td></tr><tr><td>Android 13</td><td>T</td><td>33</td></tr><tr><td>Android 12L</td><td>S</td><td>32</td></tr><tr><td>Android 12.0</td><td>S</td><td>31</td></tr><tr><td>Android 11.0</td><td>R</td><td>30</td></tr><tr><td>Android 10.0</td><td>Q</td><td>29</td></tr><tr><td>Android 9.0</td><td>Pie</td><td>28</td></tr><tr><td>Android 8.1</td><td>Orea</td><td>27</td></tr><tr><td>Android 8.0</td><td>Orea</td><td>26</td></tr></tbody></table>

# 3.user cases

(1) Case:Login  
(2) Case:Register  
(3) Case:ExitApp  
(4) Case:LogOut  
(5) Case:UserInfo  
(6) Case:GetPersonInfo  
(7) Case:SetPersonInfo  
(8) Case:Equipment  
(9) Case:ConnectEquip  
(10) Case:GetEquipInfo  
(11) Case:UnbindEquip  
(12) Case:GetEquipStatus  
(13) Case:CollectData  
(14) Case:GetUserGuide  
(15) Case:PredModel  
(16) Case:ResetModel  
(17) Case:TrainModel  
(18) Case:PredUserMotion_Onetime  
(19) Case:PredUserMotion_Sync  
(20) Case:ShowModelInfo  
(21) Case:DataManagement  
(22) Case:GetData  
(23) Case:DiscardData  
(24) Case:ChangeDataLabel

### Case Specification Mode

<table><tbody><tr><td>Use Case</td><td>&nbsp;</td></tr><tr><td>ID</td><td>&nbsp;</td></tr><tr><td>Source</td><td>&nbsp;</td></tr><tr><td>Brief Description</td><td>&nbsp;</td></tr><tr><td>Primary Actors</td><td>&nbsp;</td></tr><tr><td>Second Actors</td><td>&nbsp;</td></tr><tr><td>PreConditons</td><td>&nbsp;</td></tr><tr><td>Main Flow</td><td>&nbsp;</td></tr><tr><td>PostConditons</td><td>&nbsp;</td></tr><tr><td>Alternative Flows</td><td>&nbsp;</td></tr></tbody></table>

### Alternative Flow

<table><tbody><tr><td>Alternative Flow</td><td>&nbsp;</td></tr><tr><td>ID</td><td>&nbsp;</td></tr><tr><td>Source</td><td>&nbsp;</td></tr><tr><td>Brief Description</td><td>&nbsp;</td></tr><tr><td>Primary Actors</td><td>&nbsp;</td></tr><tr><td>Second Actors</td><td>&nbsp;</td></tr><tr><td>PreConditons</td><td>&nbsp;</td></tr><tr><td>Main Flow</td><td>&nbsp;</td></tr><tr><td>PostConditons</td><td>&nbsp;</td></tr></tbody></table>

### Use-case Diagram

![](https://s1.ax1x.com/2023/03/29/ppgUlw9.jpg)

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

<table><tbody><tr><td>Use Case</td><td>Register</td></tr><tr><td>ID</td><td>3</td></tr><tr><td>Source</td><td>User</td></tr><tr><td>Brief Description</td><td>Register user</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI in visitor mode</td></tr><tr><td>Main Flow</td><td>1. User inputs UserName<br>2. GUI checks whether username is legal<br>3. User inputs password<br>4. GUI checks whether password is legal<br>5. User reinputs password<br>6. GUI checks whether the two passwords are same<br>7. User inputs other information<br>8. GUI checks whether the information is legal<br>9. GUI sends information to Server<br>10. Server save ID and information to user database<br>11. Database saved<br>12. Server calculate a new ID for the User, and returns id<br>13. GUI shows successful notion and UserID<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>User registered</td></tr><tr><td>Alternative Flows</td><td>2.2 If username is not legal, shows mistake notion and back to step 1 4.2 If password is not legal, shows mistake notion and back to step 3 6.2 If password is different, shows mistake notion and back to step 5 8.2 If information is not legal, shows mistake notion and back to step 7 9.2 If GUI has not connected to Internet, GUI shows the mistake notion, and back to Equip mode<br>13.2 If GUI receives error information(For example, the user has connected to one equip), GUI shows the error notion, and back to Equip mode<br>13.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:LogOut

![](https://s1.ax1x.com/2023/03/19/pptClz4.png)

<table><tbody><tr><td>Use Case</td><td>LogOut</td></tr><tr><td>ID</td><td>4</td></tr><tr><td>Brief Description</td><td>User log out</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in the app.</td></tr><tr><td>Main Flow</td><td><p>1.User click the “log out” button</p><p>2.The app turn to visitor mode</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:UserInfo

![](https://s1.ax1x.com/2023/03/19/pptCBSe.png)

<table><tbody><tr><td>Use Case</td><td>UserInfo</td></tr><tr><td>ID</td><td>5</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>User choose to do something with personal information.and change to user information mode</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in.</td></tr><tr><td>Main Flow</td><td><p>1.User click the “User Information” button.</p><p>2.Jump to User Information interface</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:GetPersonInfo

![](https://s1.ax1x.com/2023/03/19/pptCcwt.png)

<table><tbody><tr><td>Use Case</td><td>GetPersonInfo</td></tr><tr><td>ID</td><td>5.1.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Get the personal information set before.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User choose the “user information” button.</td></tr><tr><td>Main Flow</td><td><p>1.User choose to get personal information.</p><p>2.Get personal information from database.</p><p>3.Display personal information on the screen.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:SetPersonalInfo

![](https://s1.ax1x.com/2023/03/19/pptCffS.png)

<table><tbody><tr><td>Use Case</td><td>SetPersonalInfo</td></tr><tr><td>ID</td><td>5.2.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Add personal information to database.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User choose the “user information” button.</td></tr><tr><td>Main Flow</td><td><p>1.User choose to set personal information.</p><p>2.User input personal information</p><p>3.If the information is valid</p><p>&nbsp; 3.1.Database save the information.</p><p>4.Display successful notion on screen.</p></td></tr><tr><td>PostConditons</td><td>New personal information has been added to database.</td></tr><tr><td>Alternative Flows</td><td>InvalidPersonalInformation</td></tr></tbody></table>

<table><tbody><tr><td>Alternative Flow</td><td>SetPersonalInfo:InvalidPersonalInformation</td></tr><tr><td>ID</td><td>5.2.1.</td></tr><tr><td>Source</td><td>database</td></tr><tr><td>Brief Description</td><td>Inform user that he or she has entered invalid information.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>The user has input invalid information.</td></tr><tr><td>Main Flow</td><td><p>1.The alternative flow begins after step 3 of the main flow</p><p>2.The app informed the user that he or she has input invalid information.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr></tbody></table>

### Case:Equipment

![](https://s1.ax1x.com/2023/03/19/pptCHwq.png)

<table><tbody><tr><td>Use Case</td><td>Equipment</td></tr><tr><td>ID</td><td>6</td></tr><tr><td>Source</td><td>server</td></tr><tr><td>Brief Description</td><td>The user who have auxiliary walking tools choose to bind the tools with app to get better prediction.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in.</td></tr><tr><td>Main Flow</td><td><p>1.User click the equipment button.</p><p>2.Jump to equipment interface.</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:ConnectEquip

![](https://s1.ax1x.com/2023/03/29/ppgUyfP.jpg)

<table><tbody><tr><td>Use Case</td><td>ConnectEquip</td></tr><tr><td>ID</td><td>6.1</td></tr><tr><td>Source</td><td>User</td></tr><tr><td>Brief Description</td><td>User input the IP address and port of the equipment, and Server saved this to Equip DataBase</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed into Equipment mode</td></tr><tr><td>Main Flow</td><td>1. User Click "ConnectEquip" button<br>2. GUI shows the textbox, and wait user to input IP address and port<br>3. User inputs IP address and port<br>4. GUI checks whether the input contents are legal<br>5. If they are legal, give them to server<br>6. Server save the IP address and port to Equipment DataBase<br>7. Equipment DataBase has saved<br>8. Server return success information to GUI<br>9. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>Equipment saved to Equipment DataBase, and Server will charge of corresponding to Equipment</td></tr><tr><td>Alternative Flows</td><td>4.2 If the IP address or the port is illegal, GUI shows the mistake notion, and back to step 3<br>5.2 If GUI has not connected to Internet, GUI shows the mistake notion, and back to Equip mode<br>9.2 If GUI receives error information(For example, the user has connected to one equip), GUI shows the error notion, and back to Equip mode<br>9.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:GetEquipInfo

![](https://s1.ax1x.com/2023/03/29/ppgUfmQ.jpg)

<table><tbody><tr><td>Use Case</td><td>GetEquipInfo</td></tr><tr><td>ID</td><td>6.2</td></tr><tr><td>Source</td><td>Embeddings</td></tr><tr><td>Brief Description</td><td>GUI requests Server to give the Information of User's Equipments. Usually, Server needs to check the Embedding to get the Information.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed into Equip mode</td></tr><tr><td>Main Flow</td><td>1. User Click "GetEquipInfo" button<br>2. GUI sends the request to Server<br>3. Server requests Embedding to return the information of Equipment<br>4. Embedding give the information to Server<br>5. Server gives the information to GUI<br>6. GUI shows Equipment Information<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI gets the equipment information</td></tr><tr><td>Alternative Flows</td><td>3.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>6.2 If GUI receives mistake information(For example, Server cannot connect the Equipment), GUI shows the mistake information and back to Equip mode<br>6.3 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>6.4 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:UnbindEquip

![](https://s1.ax1x.com/2023/03/29/ppgUhwj.jpg)

<table><tbody><tr><td>Use Case</td><td>UnbindEquip</td></tr><tr><td>ID</td><td>6.3</td></tr><tr><td>Source</td><td>Server</td></tr><tr><td>Brief Description</td><td>GUI shows</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed into Equip mode</td></tr><tr><td>Main Flow</td><td>1. User clicks "UnbindEquip" button<br>2. GUI sends request of getting Equipment list to Server<br>3. Server checks the Equipment DataBase<br>4. Equipment DataBase returns the result to Server<br>5. Server gives the result to GUI<br>6. GUI shows the Equipment list and information to Server<br>7. User chooses the Equipment to unbind<br>8. GUI sends request of unbinding equipment<br>9. Server deletes the Equipment on this user DataBase<br>10. DataBase deletes<br>11. Server return the success result<br>12. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>Equipment of User is successfully unbinded</td></tr><tr><td>Alternative Flows</td><td>3.2 If GUI has not connected to Internet, show mistake notion and back to Equip mode<br>6.2 If there is no equipments on the user, show mistake notion and back to Equip mode<br>8.2 If GUI has not connected to Internet, show mistake notion and back to Equip mode<br>12.3 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>12.4 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:GetEquipStatus

![](https://s1.ax1x.com/2023/03/29/ppgUoYq.jpg)

<table><tbody><tr><td>Use Case</td><td>GetEquipStatus</td></tr><tr><td>ID</td><td>6.4</td></tr><tr><td>Source</td><td>Embeddings</td></tr><tr><td>Brief Description</td><td>GUI requests Server to give the Status of User's Equipments. Usually, Server needs to check the Embedding to get the Status.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed into Equip mode</td></tr><tr><td>Main Flow</td><td>1. User Click "GetEquipInfo" button<br>2. GUI sends the request to Server<br>3. Server requests Embedding to return the Status of Equipment<br>4. Embedding give the Status to Server<br>5. Server gives the Status to GUI<br>6. GUI shows Equipment Status<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI gets the equipment information</td></tr><tr><td>Alternative Flows</td><td>3.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>6.2 If GUI receives mistake information(For example, Server cannot connect the Equipment), GUI shows the mistake information and back to Equip mode<br>6.3 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>6.4 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:CollectData

![](https://s1.ax1x.com/2023/03/29/ppgULXF.jpg)

<table><tbody><tr><td>Use Case</td><td>CollectData</td></tr><tr><td>ID</td><td>6.5</td></tr><tr><td>Source</td><td>Embedding</td></tr><tr><td>Brief Description</td><td>GUI requests server to begin and end getting data, and Server takes charge of managing embedding, get and save data, save to DataBase.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed into Equip mode</td></tr><tr><td>Main Flow</td><td>1. User click "Collect Data" button<br>2. GUI shows the type of Data, and wait user to choose<br>3. User choose one type of data<br>4. GUI requests the server to begin collecting data<br>5. Server requests the Embedding to begin collecting data<br>6. Embedding gives data to Server<br>7. Server saves the data local<br>8. User click "Finish Data" button<br>9. GUI requests the server to end collecting data<br>10. Embedding stop transporting data<br>11. Server saves data to data dataBase<br>12. Data database successfully saved<br>13. Server tells GUI<br>14. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>Data has collected and saved to Data DataBase</td></tr><tr><td>Alternative Flows</td><td>4.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>8.2 If Server waits more than time limitation, server stops data collecting<br>9.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>14.2 If GUI receives error information, GUI shows error notion and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:GetUserGuide

![](https://s1.ax1x.com/2023/03/19/pptPJ1g.png)

<table><tbody><tr><td>Use Case</td><td>Get User Guide</td></tr><tr><td>ID</td><td>7</td></tr><tr><td>Source</td><td>GUI (local)</td></tr><tr><td>Brief Description</td><td>User get the app's user guide</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>A user has logged in.&nbsp;</td></tr><tr><td>Main Flow</td><td><p>1.The user choose to ger user guide</p><p>2.Get user guide and show it on screen</p></td></tr><tr><td>PostConditons</td><td>none</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:PredModel

![](https://s1.ax1x.com/2023/03/19/pptZTo9.jpg)

<table><tbody><tr><td>Use Case</td><td>PredModel</td></tr><tr><td>ID</td><td>8</td></tr><tr><td>Source</td><td>none</td></tr><tr><td>Brief Description</td><td>Change into model mode to get prediction results</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User has log in</td></tr><tr><td>Main Flow</td><td>1. User clicks Model<br>2. GUI changes into model mode<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI changes into model mode</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:ResetModel

![](https://s1.ax1x.com/2023/03/29/ppgUv79.jpg)

<table><tbody><tr><td>Use Case</td><td>ResetModel</td></tr><tr><td>ID</td><td>8.1</td></tr><tr><td>Source</td><td>Model DataBase</td></tr><tr><td>Brief Description</td><td>GUI requests Server to change the model of the user to initial model, whether the model of user is initial model or not.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed into Model mode</td></tr><tr><td>Main Flow</td><td>1. User clicks "ResetModel" button<br>2. GUI sends request to Server<br>3. Server does reset work on Algorithm database<br>4. Algorithm database successfully resetted<br>5. Server tells GUI<br>6. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>The model of user resetted on his Algorithm database</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>6.2 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>6.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:TrainModel

![](https://s1.ax1x.com/2023/03/29/ppgapfx.jpg)

<table><tbody><tr><td>Use Case</td><td>TrainModel</td></tr><tr><td>ID</td><td>9.2</td></tr><tr><td>Source</td><td>Data Database</td></tr><tr><td>Brief Description</td><td>User choose data to train model</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>Gui has changed to Model mode</td></tr><tr><td>Main Flow</td><td>1. User click "TrainModel" button<br>2. GUI requests Server on getting data list<br>3. Server makes data list&nbsp;<br>4. Data database returns data list of the user<br>5. Server gives data list to GUI<br>6. GUI shows data list<br>7. User chooses data<br>8. GUI sends data list to Server<br>9. Server get data from database<br>10. Data database gives data to server<br>11. Server gives data to Algorithm Running Unit to train model<br>12. Algorithm Running Unit trains model, and gives model to Server<br>13. Server gives model to Algorithm to Algorithm database<br>14. Algorithm database saved<br>15. Server returns successful information<br>16. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>Trained model saved to Algorithm database</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>6.2 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>6.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>8.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>16.2 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>16.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:PredUserMotion_Onetime

![](https://s1.ax1x.com/2023/03/29/ppgai6O.jpg)

<table><tbody><tr><td>Use Case</td><td>PredUserMotion_Onetime</td></tr><tr><td>ID</td><td>9.3</td></tr><tr><td>Source</td><td>Algorithm running unit</td></tr><tr><td>Brief Description</td><td>Use trained model and data from Embedding, to calculate the status of equipment and GUI shows the result, but only one time</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed to Model mode</td></tr><tr><td>Main Flow</td><td>1. User click "PredUserMotion_Sync" button<br>2. GUI send request of getting outcome one_time to Server<br>3. Server gets the model of user from Algorithm database<br>4. Algorithm returns the model<br>5. Server installs the model on Algorithm running unit<br>6. Algorithm running unit installed<br>7. Server gets data from Embedding<br>8. Embedding returns data to Server<br>9. Server gives data to Algorithm running unit<br>10. Algorithm running unit calculates the result<br>11. Server gives the result to GUI<br>12. GUI shows the outcome<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI gets the result(the status of embedding)</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>12.2 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>12.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:PredUserMotion_Sync

![](https://s1.ax1x.com/2023/03/29/ppgaV7d.jpg)

<table><tbody><tr><td>Use Case</td><td>PredUserMotion_Sync</td></tr><tr><td>ID</td><td>9.4</td></tr><tr><td>Source</td><td>Algorithm running unit</td></tr><tr><td>Brief Description</td><td>Use trained model and data from Embedding, to calculate the status of equipment and GUI shows the result, until user stops</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>None</td></tr><tr><td>PreConditons</td><td>GUI has changed to Model mode</td></tr><tr><td>Main Flow</td><td>1. User click "PredUserMotion_Sync" button<br>2. GUI makes connections to Server<br>3. Server makes connections<br>4. GUI send request of getting outcome one_time to Server<br>5. Server gets the model of user from Algorithm database<br>6. Algorithm returns the model<br>7. Server installs the model on Algorithm running unit<br>8. Algorithm running unit installed<br>9. Server gets data from Embedding<br>10. Embedding returns data to Server<br>11. Server gives data to Algorithm running unit<br>12. Algorithm running unit calculates the result<br>13. Server gives the result to GUI<br>14. GUI shows the outcome<br>15. User click "end" button<br>16. GUI releases connection<br>17. Server releases connection<br>18. Server stops getting data<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI gets the result(the status of embedding)</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>14.2 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>14.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>17.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:ShowModelInfo

![](https://s1.ax1x.com/2023/03/29/ppgaeAA.jpg)

<table><tbody><tr><td>Use Case</td><td>ShowModelInfo</td></tr><tr><td>ID</td><td>9.5</td></tr><tr><td>Source</td><td>Algorithm DataBase</td></tr><tr><td>Brief Description</td><td>GUI gets information of model from server. Usually, server should get the information from algorithm database.</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User has changed into Model mode</td></tr><tr><td>Main Flow</td><td>1. User click "ShowModelInfo" button<br>2. GUI sends request of getting model information<br>3. Server gets model information of the user from Algorithm database<br>4. Algorithm database returns the model information<br>5. Server gives them to GUI<br>6. GUI shows the information<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>&nbsp;</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI has not connected to Internet, GUI shows mistake information and back to Equip mode<br>6.2 If GUI receives error information, GUI shows the error notion, and back to Equip mode<br>6.3 If GUI waits more than time limitation, GUI shows the error notion, and back to Equip mode<br>&nbsp;</td></tr></tbody></table>

### Case:DataManagement

![](https://s1.ax1x.com/2023/03/19/ppteak9.jpg)

<table><tbody><tr><td>Use Case</td><td>Data Management</td></tr><tr><td>ID</td><td>10</td></tr><tr><td>Source</td><td>none</td></tr><tr><td>Brief Description</td><td>Change into data mode to manage the collected data</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>User has log in</td></tr><tr><td>Main Flow</td><td>1. User clicks Data management<br>2. GUI changes into data mode<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI changes into data mode</td></tr><tr><td>Alternative Flows</td><td>none</td></tr></tbody></table>

### Case:GetData

![](https://s1.ax1x.com/2023/03/19/ppter6K.jpg)

<table><tbody><tr><td>Use Case</td><td>Get Data</td></tr><tr><td>ID</td><td>10.2</td></tr><tr><td>Source</td><td>DataBase</td></tr><tr><td>Brief Description</td><td>Get datalist from data DataBase</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has changed into data mode</td></tr><tr><td>Main Flow</td><td>1. User clicks get data<br>2. GUI gets data information from data database<br>3. Data database returns data information<br>4. GUI shows data information<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI upload data to data database, and back into data mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>&nbsp;</td></tr></tbody></table>

### Case:DiscardData

![](https://s1.ax1x.com/2023/03/19/pptec0e.jpg)

<table><tbody><tr><td>Use Case</td><td>Discard Data</td></tr><tr><td>ID</td><td>10.3</td></tr><tr><td>Source</td><td>DataBase</td></tr><tr><td>Brief Description</td><td>Get datalist from data DataBase, and delete chosen data</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has changed into data mode</td></tr><tr><td>Main Flow</td><td>1. User clicks get data<br>2. GUI gets datalist information from data database<br>3. Data database returns datalist information<br>4. GUI shows data information<br>5. User chooses data to delete<br>6. GUI send delete request to data Database<br>7. Data database delete the data chosen<br>8. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>Discard chosen data from data database, and GUI back into data mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>3.2 If nothing on datalist, GUI shows mistake notion and back to data mode<br>5.2 If User chooses nothing or quit, GUI shows delete nothing and back to data mode<br>6.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>&nbsp;</td></tr></tbody></table>

### Case:ChangeDataLabel

![](https://s1.ax1x.com/2023/03/19/ppteRkd.jpg)

<table><tbody><tr><td>Use Case</td><td>Change the label of data</td></tr><tr><td>ID</td><td>10.4</td></tr><tr><td>Source</td><td>DataBase</td></tr><tr><td>Brief Description</td><td>Change the label of data in database</td></tr><tr><td>Primary Actors</td><td>User</td></tr><tr><td>Second Actors</td><td>none</td></tr><tr><td>PreConditons</td><td>GUI has changed into data mode</td></tr><tr><td>Main Flow</td><td>1. User clicks change label<br>2. GUI gets data information from data database<br>3. Data database returns data information<br>4. GUI shows data information<br>5. User chooses data to change, and chooses the new type<br>6. GUI send alter request to data database<br>7. Database update the new label of data<br>8. GUI shows successful notion<br>&nbsp;</td></tr><tr><td>PostConditons</td><td>GUI upload data to data database, and back into data mode</td></tr><tr><td>Alternative Flows</td><td>2.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>3.2 If nothing on datalist, GUI shows mistake notion and back to data mode<br>5.2 If User chooses nothing, or the new type is the same as the old one, or quit, GUI shows alter nothing and back to data mode<br>6.2 If GUI cannot connect to Internet, shows mistake notion and back to data mode<br>&nbsp;</td></tr></tbody></table>

# 4.Behavioral Requirements

## 4.1.System Inputs and Outputs

### 4.1.1.Inputs

Inputs to the app come from the user. Users can select options such as personal information,equipment and so on from the main menu. On the login screen, you can enter the text box, and on the personal information screen, you can choose to modify the information. In the equipment interface, there are options such as adding devices, unbinding devices, and viewing device status.

**Inputs When Editing Personal information:**  
\*_UserID_:An id that's unique to each user,composed of 11 digits

\*_password_: A string consisting of at least n digits number and characters to whether the guest is the user

\*_username_: A contact can have a first name, or last name, or both. The first and last names will be separate fields. The system will accept any characters in the first and last name fields.

\*_basicinformation_: The information provided by the user, which is mainly the user's contact information and physical condition

\*_IPaddress_:The IP address of equipment. Embedding group make sure the IP address and the port of each equipment is eternal, which means it will not change.

\*_TypeofData_:The type of data user wants to collect.

### 4.1.2.Outputs

The GUI display all information, such as user information, sensor information, user guide and each window contains any created contacts and interactable buttons for the user.

**Outputs to The User:**

\*_viewing equipment status:_ Show all devices that have been bound, if not, a blank background will be displayed.

\*_collectData_: After clicking “Start collecting” button, the sensor starts to collect data, the "Stop Collecting" button appear new. If you stop collecting data, the app will generate a window asking whether to discard the data .

\*_personal information of user:_ user detailed information, including the User ID, email, real name, body information and so on. Users can click the "Modify Information" button to modify the information and display it.

\*_user guide_:  the window contains the instruction manual to guide the user to use the system

### 4.2   Quality Requirements

The application must be competitive with similar applications in regards to performance, reliability, consistency, and scalability.

Performance: Responsiveness to user input  
\* Standard actions that manipulate interaction should not exceed 300ms execution time.  
\* The system will auto-load every 5 seconds.  
\* The app will automatically hibernate after 30 seconds of inactivity

Reliability: Confidence that actions taken will not result in errors, and that changes made to program are persistent  
\* User input should not produce faults or errors that impact or hinder use of the application  
\* Any modifications to program should produce a lasting change that persists through any following series of actions taken by the user.  
\* Any fault happen in server won't result in a fault in GUI

Consistency: Persistent data in program contents  
 \* program contents should be modifiable after being added in such a way that target fields can be changed without affecting data in other fields.

Scalability: Ease of extending application capabilities  
\* Application should be modularized such that adding/extending features and functions only require changes to a single component and the interface with that component, if applicable.

# 5.Expected Subsets

## L0:

\-Basic GUI with ability to connect to sensor and view infformation

\-Ability to register, log in and log out

\-Ability to modify user information

\-Ability to collect user's motion data

\-Ability to manage collected data

\-Ability to get predict result

L1:

\-Complete GUI for making the interface user-friendly

\-Complete GUI with the ability of showing predict results visually

\-Ability to connect to sensor by bluetooth
