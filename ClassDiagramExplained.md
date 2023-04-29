
# <p align="center" >Class Diagram</p>

## Diagram
![Class Diagram](https://i.imgur.com/jIBGLLq.png)

## Method Explanation
### <p align = "center">User</p>

* __setUserInfo(string, string, string, Date):bool__ - This method should allow the user to update it's information. It takes as parameters three strings, representing the user's name, email and phone Number, and a Date representing the user's birthday. This method returns a bool representing it's success.
</br> Ex:

```csharp
public bool setUserInfo(string name, string email, string phoneNumber, Date birthday)
	{
		if(!this.getLogged()) return false;
		
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			type = "ChangeUserInfo",
			id = $"{this.getId()}",
			password = $"{this.getPassword()}",
            		username = $"{name}",
			email = $"{email}",
            		phoneNumber = $"{phoneNumber}",
			birthday = $"{birthday.toString()}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PostAsync(apiURL, jsonContent);
		if((int)response.StatusCode==404)return false; //Deal with patch failure (deal with other status codes)
		
		this.setName(name);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setBirthday(birthday);
		
		return true;
	}
 ```


* __updatePassword(string, string):bool__- This method is used to update the user's password when they're already logged into their account. The user inserts their previous password, and the password they wish to change it to. This method should compare the current user password, stored in the database, with the hash of the text in the previous user password text box, and if they match it should make a PUT/PATCH call to the user database API changing the previous password to the new one(the hash of the text in the new password text box). This method takes as parameter two strings, one storing the value the user wrote in the previousePassword textbox, and the other storing the value the user wrote in the newPassword textbox. This method returns a bool representing it's success.
</br> Ex:

```csharp
public bool updatePassword(string newPassword,string oldPassword)//newPassword and oldPassword are the values inserted by the user in the textboxes
	{
		byte[] passwordBytes = Encoding.UTF8.GetBytes(oldPassword);
            	byte[] passwordHashBytes = SHA256.HashData(passwordBytes);//whatever hasing algorithm is used for the passwords in database
		string textBoxPreviousPassword = BitConverter.ToString(passwordHashBytes)
		if(user.getPassword() !=  oldPassword)
		{
			//Warn user wrong Password
			return;
		} 

		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		password =  $"{newPassword}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + this.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
		
		this.setPassword(password);
		return true;
	}
 ```

* __getUserGuide():File__ - This method should retrieve from user's phone a file explaining how the application operates and should be used, in order to provide some explanations and clarify some doubts they may have. This method returns a file containing that information, or null in the case of failure to retrieve it.

### <p align="center">Authentication</p>

* __login(User, string, string):bool__ - This method should allow a user to login into their previously created account. If the credentials inserted by the user are associated with an existing account that's stored in the user database, and the login process is successful, this method updates the local user instance with the other information stored about that particular user in the user database. It takes as parameters two strings, one storing the value the user wrote in the id textbox in the login view, and the other one storing the value they wrote in the password textbox in the login view, and a User instance. This method should return false in the case of login failure and true in the case of success.
</br> Ex:

```csharp
public static bool login(User user, string id, string password)
	{
				
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			type = "Login",
			id = $"{id}",
			password = $"{password}"
        	}),
		Encoding.UTF8,
        	"application/json");
		
		using HttpResponseMessage response = await httpClient.PostAsync(apiURL, jsonContent);
		
		if(response.StatusCode == "404") return false; //We could verify for more status codes, displaying different messages

		user.setId(id);
		user.setPassword(password);
		
		using HttpResponseMessage getResponse = await httpClient.GetAsync(userURL + "?id=" + id, jsonContent);				
		var jsonResponse = await getResponse.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		
		user.setLogged();
		user.setEmail(jsonNode["email"]);
		user.setPhoneNumber(Convert.ToInt32(jsonNode["phoneNumber"]));
		user.setUserName(jsonNode["userName"]);
		string birthday=jsonNode["birthday"];//verify if is null
		user.setBirthday(SimpleDateFormat("dd/MM/yyyy").parse(birthday););
		
		return true;
	}
```

* __logout(User)__ : bool - This method is called when the user wishes to logout of their account, deleting the User instance. It should return false in the case the user received isn't logged in, and true in case of success.
</br> Ex:

```csharp
public static bool logout(User user)
	{
		if(!user.getLogged()) return false
		user.setLogged(); // if fails return false 
		user.setId(NULL);
		user.setEmail(NULL);
		user.setPassword(NULL);
		user.setEmail(NULL);
		user.setuserName(NULL);
		user.setBirthday(NULL);
		
		return true
	}
```

* __register(User, string, string):bool__ - This method should allow a user to register a new account for the application. If the credentials inserted by the user for the new account are accepted, and a new account is registered succesfully, this method updates the local User instance, storing in it the id and password. This method takes as parameter two strings, one storing the value the user wrote in the id textbox, and the other one storing what they wrote in the password textbox in the register view and an instance of User. This returns true in the case of registar success and false in the case of failure.

</br> Ex:

```csharp
public static bool register(User user, string id, string password)
	{		
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			type = "Register",
			id = $"{id}",
			password = $"{password}",
            		username = NULL,
			email = NULL,
            		phoneNumber = NULL,
			birthday = NULL
        	}),
        	Encoding.UTF8,
        	"application/json");
	
    		using HttpResponseMessage response = await httpClient.PostAsync(apiURL, jsonContent);
    		if(response.StatusCode=="404") return false; // deal with other status codes

		user.setId(id);
		user.setPassword(password);
		user.setUsername(NULL);
		user.setEmail(NULL);
		user.setPhoneNumber(NULL);
		user.setBirthday(NULL);
		user.setLogged();
		
		return true;
	}
```

### <p align="center">DataManagement</p>

* __getData(string):List<Motion__ - This method should allow the user to retrieve all data records, that they've collected, from the data database. The data being retrieved will be returned in a Json format that should then be parsed and used to create a list of Motion instance that the method then returns. This method takes as parameter a string representing the id of the user currently calling the method. This method returns the list of Motion instances generated in the case of success, or null in the case of failure.
</br> Ex:

```csharp
public List<Motion> getData(string userId)/
{
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			type = "GetData",
			id = "userId"
        	}),
        	Encoding.UTF8,
        	"application/json");
	
	HttpResponse response = await client.getAsync(apiURL, jsonContent);
	
	
	if(response.IsSuccessStatusCode){
		list<Motion> motionList = new List<Motion>();
		string json = await response.Content.ReadAsStringAsync();
    		jsonArray motionHistory = JsonConvert.DeserializeObject<jsonArray>(json);
	
    		foreach (jsonNode motionRecord in motionHistory)
    			{       			
				Motion motion = new Motion(motionRecord["startTime"], motionRecord["typeOfMotion"], motionRecord["duration"]);
            			motionList.Add(motion);
    			}
    		
		return motionList;
	}
	return null;
}
```



* __discardData(string, string):bool__ - This method should delete some data entry selected by the user from the data entries, associated with the user currently calling the method, in the data database. This method takes as a parameter a string representing the id of the user currently calling the method, and a string representing the id of the motion to be deleted. This method returns a bool representing it's success.
</br> Ex:

```csharp

public bool discardData(string startTime, string userId){

	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			type = "DiscardData",
			id = $"{userId}",
			startTime = $"{startTime}"
        	}),
        	Encoding.UTF8,
        	"application/json");
	
	//the data linked to the user id will be deleted
	HttpResponse response = await client.PostAsync(apiURL, jsonContent);
	return response.IsSuccessStatusCode;
}

```


* __ChangeLabel(string, string, string):bool__ - This method should allow the user to changne the label associated with some previously collected data. This method takes in a string representing the new label the user wishes to associate with the data selected, a string representing the data whose label needs to be changed, and a string representing the id of the user currently calling the method. This method returns a bool representing it's success.

```csharp

public bool ChangeLabel(string motionType, string userId, string startTime){

	JsonSerializer.Serialize(new
       	{
		type = "ChangeLabel",
		account = $"{userId}",
		startTime = $"{startTime}",
   		label =  $"{motionType}"
       	}),
       	Encoding.UTF8,
       	"application/json");
	using HttpResponseMessage response = await httpClient.PatchAsync(apiURL, jsonContent);
	
	if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
	
	return true;
		
}

```


### <p align="center">Equipment</p>

* __connectEquipment(string, string, int, int):bool__ - This method is supposed to allow the user currently calling it to connect to the sensors. If the equipment is available then the user should be able to connect to it, otherwise they should be warned of it's unavailability. This method takes as parameters two strings and two integers. The first string represents the id of the user currently calling the method, and the second string represents the type of equipment. The integers represent the port and the ip of the sensor. This method returns a bool based on it's success

</br> Ex:

```csharp

public bool connectEquipment(string userId, string type, int ip, int port){
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			Type = "ConnectEquipment"
			id = $"{userId}"
            		ip = $"{ip}",
			type = $"{type}",
			port = $"{port}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(apiURL , jsonContent);
	
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect
}

```

* __disconnectEquipment(string):bool__ - This method is supposed to allow the user currently calling it to disconnect from the sensors. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection), or the user should be informed, when trying to call this method, that they need to connect to the equipment first. This method takes, as a parameter, a string representing the id of the user currently calling it, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool disconnectEquipment(string userId){
		
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			Type = "DisconnectEquipment"
            		id = $"{userId}"
        	}),
        	Encoding.UTF8,
        	"application/json");	
	HttpResponseMessage response = await client.PostAsync(apiURL, jsonContent);
	
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect
}

```

* __collectData(string, string):bool__ - This method should warn the server that the user that last connected to the equipment wants to start collecting data. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection), or the user should be informed, when trying to call this method, that they need to connect to the equipment first. This method takes as parameters a string representing the id of the user currently calling the method, and a string, representing the type of movemente the user intends to collect data for. This method returs a bool based on it's success.
</br> Ex:

```csharp

public bool collectData(string userId, string movementType){
	
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
			Type = "CollectData"
            		userID = $"{userId}",
			label = $"{movementType}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(apiURL, jsonContent);
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	
	return true; 	
}
```

* __collectDataStop(string):bool__ - This method should warn the server that the user that last connected wants to stop collecting data. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection) and is currently collecting data, or the user should be informed, when trying to call this method, that they need to start collecting data before they can stop data collection. This method takes as parameter a string representing the id of the user currently calling the method, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool collectDataStop(string userId){
	
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		Type = "CollectDataStop"
            		userID = $"{userId}",
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(apiURL, jsonContent);
	if(response.StatusCode == "404") return false; //Deal with other possible status codes

	return true;
}
```


* __getEquipmentStatus():string__ - This method should retrieve the status of the sensors. The method makes a get call to the sensor API, receiving a JsonArray with each entry representing a sensor. The method then parses the array, retreiving the status of each sensor and creating a string that is then returned. In case of failure the method returns null.
</br> Ex:

```csharp

public string getEquipmentStatus(){
		
	HttpResponse response = await client.getAsync(sensorURL);
	
	
	if(response.IsSuccessStatusCode){
		string response = await response.Content.ReadAsStringAsync();

		JsonArray sensorArray = JsonSerializer.Deserialize<JsonArray>(response);
		string status="";
		
		foreach (JsonNode sensor in sensorArray.AsArray())
    		{
        		status += $"\nSensor {sensor["sensorId"]}: {sensor["status"]}";
        	}
		
		return status;
    	}
    	return null; //warn user of failure
}
```

* __getEquipmentInfo():string__ - This method should retrieve information about the sensors. The method makes a get call to the sensor API, receiving a JsonArray with each entry representing a sensor. The method then parses the array, retreiving the all the relevant information of each senso, creating a string of information that is then returned and can be presented. In case of failure the method returns null.
</br> Ex:

```csharp

public string getEquipmentInfo(){
	
	HttpResponse response = await client.getAsync(sensorURL);
	
	
	if(response.IsSuccessStatusCode){
		string response = await response.Content.ReadAsStringAsync();

		JsonArray sensorArray = JsonSerializer.Deserialize<JsonArray>(response);
		string info="";
		
		foreach (JsonNode sensor in sensorArray.AsArray())
    		{
        		info += $"\nSensor {sensor["sensorId"]}: {sensor[" "]} ; {sensor[" "]}; {sensor[" "]}"; //repeat for all sensor info to present
        	}
		
		return info;
    	}
    	return null; //warn user of failure
}
```

### <p align="center">PredictionModel</p>

* __getPrediction(string):string__ - This method should allow the user to retrieve prediction that the prediction model makes based on the current data the user is sending it and the data it has sent previously, and that is stored in the data database. This method takes as parameter a string representing the id of the user currently calling the method and returns a string that includes the current prediction model prediction. In case of failure the method returns null.
</br> Ex:

```csharp
public string getPrediction(string userId){

	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		Type = "GetPrediction"
            		userID = $"{userId}",
        	}),
        	Encoding.UTF8,
        	"application/json");

	HttpResponse response = await client.PostAsync(apiURL, jsonContent);
	if(response.StatusCode == "404") return null; //Deal with other possible status codes
	
	var jsonResponse = await response.Content.ReadAsStringAsync();		
	JsonNode jsonNode = JsonNode.Parse(jsonResponse);
	
	return jsonNode["prediction"].ToString();
}
```

* __predictUserMotions(string):string__ - This method should allow the user to start receiving real time predictions made by the prediction model, by starting a thread that executes the method predictUserMotion, responsible for calling the getPrediction method every two seconds. The predictions returned by this method are added to a prediction list that can then be displayed to the user in real time. This method should either only be allowed to be called by a user that is currently connected to the sensor equipment, or the user should be informed, when trying to call this method, that they need to connect to equipment first. This method takes as a parameter a string representing the id of the user currently calling the method, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool predictUserMotions(string userId){

	this.setIsPredicting(true);
	this.thread = new Thread(predictUserMotionLoop(userId));
	this.thread.Start();
	
	return true;
	
}

private void predictUserMotionLoop(string userId)
{
	while (this.getIsPredicting())
        {
            string prediction = this.getPrediction(userId);
            //update list of predictions
            
            Thread.Sleep(2000);
        }
}
```

* __predictUserMotionLoopStop():bool__ - This method should allow the user to stop the proccess started by the predictUserMotions method. This method should either only be allowed to be called by users that previously called the predictUserMotion method, and were successful, or should warn the user, when trying to call this method, that they need to start receiving predictions before they can call it. This method should set the isPredicting bool variable as false in order to stop the device from keeping on requesting more predictions, and should close the thread opened in the predictUserMotions method. This method takes as parameter a string representing the id of the user currently calling the method, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool predictUserMotionLoopStop(){

	this.IsPredicting(false);
	this.thread.Join();
	return true;
}
```

* __resetModel(string):bool__ - This method should allow the user to reset their personal predition model. This method should either only be allowed to be called by a user that as collected enough data to have their own prediction model (instead of the general prediction model available to all users), or the user should be informed, when trying to call this method, that they don't have a prediction model to reset. This method takes a string as paramenter representing the id of the user currently calling the method, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool resetModel(string userId){

	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		Type = "ResetModel",
            		userID = $"{userId}"
        	}),
        	Encoding.UTF8,
        	"application/json");

	HttpResponse response = await client.PostAsync(apiURL, jsonContent);
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	return true;
}
```

### <p align="center">Graphs</p>

* __draw(Motion) : bool__ - This method should draw the graphs created to display the data collected by the sensors and retrieved from the server during collectData. It can also be used to draw graphs based on previous sessions of data collection. This method takes as a parameter a Motion instance, and returns a bool based on the success of the method.

