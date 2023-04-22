
# <p align="center" >Class Diagram</p>

## Diagram
![Class Diagram](https://i.imgur.com/HFigAOk.png)

## Method Explanation
### <p align = "center">User</p>


* __setUserNameAPI(string)__ : bool - This method should make a PUT/PATCH call to the user database API in order to add a user's name. This method takes as parameter a string storing the value the user wrote in the username textbox. This method returns a bool based on it's success.
</br> Ex:

```csharp
public bool setUserNameAPI(string name)
	{
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		username = $"{name}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + this.getId(), jsonContent);
		if((int)response.StatusCode==404)return false;; //Deal with patch failure (deal with other status codes)
		
		this.setUserName(name);
		return true;
	}
 ```



* __updatePassword(string,string)__ : bool- This method is used to update the user's password when they're already logged into their account. The user inserts their previous password, and the password they wish to change it to. This method should compare the current user password, stored in the database, with the hash of the text in the previous user password text box, and if they match it should make a PUT/PATCH call to the user database API changing the previous password to the new one(the hash of the text in the new password text box). This method takes as parameter two strings, one storing the value the user wrote in the previousePassword textbox, and the other storing the value the user wrote in the newPassword textbox. This method returns a bool representing it's success.
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

* __getUserGuide():string__ - This method should retrieve from the server some text explaining how the application operates and should be used, in order to provide some explanations and clarify some doubts the user may have. This method returns a string containing that information, or null in the case of failure to retrieve it.
</br> Ex:

```csharp
public string getUserGuide()
	{
		using HttpResponseMessage response = await httpClient.GetAsync(BaseURL + "/userguide");
		
		if(response.StatusCode == "404")//We could verify for more status codes, displaying different messages
		{
			//warn user login failed
			return null;
		}
		
				
		var jsonResponse = await response.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		
		return jsonNode["userGuide"];
	}
 ```

* __setBirthdayAPI(Date)__ : bool - This method should make a PUT/PATCH call to the user database API in order to add or change a user's birthday. This method takes as parameter a Date storing the value the user inserted as their birthday. This method returs a bool according to it's success.
</br> Ex:

```csharp
public bool setBirthdayAPI(Date birthday)
	{

		if(birthdayDatePicker.Date < Date.Today()) //or any other restrictions the birthday might have(Could be made into a method of it's own)
		{
			
			//Warn user date is not acceptable
			return false;
		}//It ins't possible to distinguish user error from API error with a bool, so maybe we should verify if date is acceptable in the window code
		
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		birthday =  $"{birthday.ToString())}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + this.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
		
		this.setBirthday(birthday);
		return true;
	}
```

* __setPhoneNumber(string)__ : bool- This method should make a PUT/PATCH call to the user database API in order to add or change a user's phone number. This method takes as parameter a string storing the value the user wrote in the phoneNumber textbox. This method returs a bool according to it's success.
</br> Ex:

```csharp
public bool setPhoneNumberAPI(string phoneNumber)
	{
		//validate phone number(Could be made into a method of it's own)
		//It ins't possible to distinguish user error from API error with a bool, so maybe we should verify if date is acceptable in the window code
		
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		phoneNumber =  $"{phoneNumber}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + this.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
		
		this.setPhoneNumber = phoneNumber
		return true;
	}
```

* __setEmail(string)__ : bool - This method should make a PUT/PATCH call to the user database API in order to change a user's email address. This method takes as parameter a string storing the new email the user wrote in the email textbox. This method returs a bool according to it's success.
</br> Ex:

```csharp
public bool setEmailAPI(string email)
	{
		JsonSerializer.Serialize(new
        	{
            		email =  $"{email}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + this.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
		
		this.setEmail(email);
		return true;
	}
```


### <p align="center">Authentication</p>

* __login(User, string, string):bool__ - This method should allow a user to login into their previously created account. If the credentials inserted by the user are associated with an existing account that's stored in the user database, and the login process is successful, this method set the user instance with the other information stored about that particular user in the user database and returns it. It takes as parameters two strings, one storing the value the user wrote in the email textbox in the login view, and the other one storing the value they wrote in the password textbox in the login view, and a User instance. This method should return false in the case of login failure and true in the case of success.
</br> Ex:

```csharp
public static bool login(User user, string email, string password)
	{
		user.setEmail(email);
		user.setPassword(password);
		
		using HttpResponseMessage response = await httpClient.PostAsync(userURL + "/login", user);
		
		if(response.StatusCode == "404")//We could verify for more status codes, displaying different messages
		{
			user.setEmail(NULL);
			user.setPassword(NULL);
			//warn user login failed
			return null;
		}
		
		using HttpResponseMessage getResponse = await httpClient.GetAsync(userURL + "?email=" + email, jsonContent);				
		var jsonResponse = await getResponse.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		
		user.setLogged();
		user.setId(Convert.ToInt32(jsonNode["id"]));
		user.setEmail(jsonNode["email"]);
		user.setPassword(jsonNode["password"]);
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
		user.setId(0);//Some representation of no user
		user.setEmail(NULL);
		user.setPassword(NULL);
		user.setEmail(NULL);
		user.setuserName(NULL);
		user.setBirthday(NULL);
		
		return true
	}
```

* __register(User, string,string):bool__ - This method should allow a user to register a new account for the application. If the credentials inserted by the user for the new account are accepted, and a new account is registered succesfully, this method creates a new User, storing the email, password and id retrieved from the database, and returns it. This method takes as parameter two strings, one storing the value the user wrote in the email textbox, and the other one storing what they wrote in the password textbox in the register view and an instance of User. This returns true in the case of registar success and false in the case of failure.

</br> Ex:

```csharp
public static User register(User user, string email, string password)
	{
		user.setEmail(email);
		user.setPassword(password);		
	
    		using HttpResponseMessage response = await httpClient.PostAsync(userURL + "/register", user);
    		if((int)response.StatusCode==404)
		{
			user.setEmail(NULL);
			user.setPassword(NULL);
			return false; //Deal with post failure(other status codes too)
		}
		using HttpResponseMessage response = httpclient.GetAsync(userURL + "?email=" + email);		
		var jsonResponse = await response.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		user.setId(Convert.ToInt32(jsonNode["id"]));
		user.setLogged();
		
		return true;
	}
```

### <p align="center">DataManagement</p>

* __getData(int,int):Motion__ - This method should allow the user to retrieve data that they've collected from the data database. The data being retrieved will be returned in a Json format that should then be parsed and used to create a Motion instance that the method then returns. This method takes as parameters two integers, one representing the id of the user currently calling the method and the other representing the id of the motion being retrieved. This method returns the Motion instance generated in the case of success, or null in the case of failure.
</br> Ex:

```csharp
public Motion getData(int id, int motionId)//user id or what may be necessary to identify the data
{
	HttpResponse response = await client.getAsync(dataURL + "/" + id + "motionID");
	
	
	if(response.IsSuccessStatusCode){
		Motion motion = new Motion();
		string json = await response.Content.ReadAsStringAsync();
    		JArray sensorDataArray = JsonConvert.DeserializeObject<JArray>(json);
	
    		foreach (JObject sensorData in sensorDataArray)
    			{
				store each entry of the data returned by the API in Motion Records
				
        			/*double timestamp = sensorData["timestamp"].Value<double>();

        			foreach (var sensor in sensorData)
        			{
            				if (sensor.Key == "timestamp")
                			continue;

            				JObject sensorValues = sensor.Value.Value<JObject>();

            				Data data = new Data
            				{
                				SensorId = sensor.Key,
                				X = sensorValues["X"].Value<double>(),
                				Y = sensorValues["Y"].Value<double>(),
                				Z = sensorValues["Z"].Value<double>(),
                				AccX = sensorValues["accX"].Value<double>(),
                				AccY = sensorValues["accY"].Value<double>(),
                				AccZ = sensorValues["accZ"].Value<double>(),
                				AsX = sensorValues["asX"].Value<double>(),
                				AsY = sensorValues["asY"].Value<double>(),
                				AsZ = sensorValues["asZ"].Value<double>(),
                				Timestamp = timestamp
            				};

            			dataList.Add(data);
        			}*/
    		}
    		//return dataList;
		return Motion
	}
	return null;
}
```

* __getAllData(int,int):Motion__ - This method should allow the user to retrieve the entire history of data that they've collected from the data database. The data being retrieved will be returned in a Json format that should then be parsed and used to create Motion instances that the method then returns. This method takes as parameters two integers, one representing the id of the user currently calling the method and the other representing the id of the motion being retrieved. This method returns the Motion instance generated in the case of success, or null in the case of failure.
</br> Ex:

```csharp
public list<Motion> getAllData(int id, int motionId)//user id or what may be necessary to identify the data
{
	HttpResponse response = await client.getAsync(dataURL+'/'+ id );
	
	
	if(response.IsSuccessStatusCode){
		List<Motion> motionList = new List<Motion>();
		string json = await response.Content.ReadAsStringAsync();
    		JArray sensorDataArray = JsonConvert.DeserializeObject<JArray>(json);
	
		foreach(var motion in motionArray)
		{
    			foreach (var sensorData in sensorDataArray)
    				{
					store each entry of the data returned by the API in Motion Records
				
        				/*double timestamp = sensorData["timestamp"].Value<double>();

        				foreach (var sensor in sensorData)
        				{
            					if (sensor.Key == "timestamp")
                				continue;

            					JObject sensorValues = sensor.Value.Value<JObject>();

            					Data data = new Data
            					{
                					SensorId = sensor.Key,
                					X = sensorValues["X"].Value<double>(),
                					Y = sensorValues["Y"].Value<double>(),
                					Z = sensorValues["Z"].Value<double>(),
                					AccX = sensorValues["accX"].Value<double>(),
                					AccY = sensorValues["accY"].Value<double>(),
                					AccZ = sensorValues["accZ"].Value<double>(),
                					AsX = sensorValues["asX"].Value<double>(),
                					AsY = sensorValues["asY"].Value<double>(),
                					AsZ = sensorValues["asZ"].Value<double>(),
                					Timestamp = timestamp
            					};

            				dataList.Add(data);
        				}*/
    				}
		//return dataList;
		motionList.Add(motion);
		}
    		return motionList
	}
	return null;
}
```

* __discardAllData(int):bool__ - This method should delete all the data stored in the data database associated with the user currently calling the method. This method takes as a parameter and integer representing the id of the user currently calling the method, and returns a bool representing it's success.
</br> Ex:

```csharp

public bool discardData(int userId){
	//the data linked to the user id will be deleted
	HttpResponse response = await client.DeleteAsync(dataUrl + "/" + userId);
	return response.IsSuccessStatusCode;
}

```

* __discardData(int, int):bool__ - This method should delete some data selected by the user from the data entries, associated with the user currently calling the method; in the data database. This method takes as a parameter and integer representing the id of the user currently calling the method, and an integer representing the id of the motion to be deleted. This method returns a bool representing it's success.
</br> Ex:

```csharp

public bool discardData(int userId, int motionId){
	//the data linked to the user id will be deleted
	HttpResponse response = await client.DeleteAsync(dataUrl + "/" + userId + "/" + motionId);
	return response.IsSuccessStatusCode;
}

```


* __ChangeLabel(enum, int, int):bool__ - This method should allow the user to changne the label associated with some previously collected data. This method takes in an enum representing the new label the user wishes to associate with the data selected, an integer representing the data whose label needs to be changed, and an int representing the id of the user currently calling the method. This method returns a bool representing it's success.

```csharp

public bool ChangeLabel(enum motionType, int userId, int motionId){

	JsonSerializer.Serialize(new
       	{
		type = "ChangeLabel",
		account = $"{userId}",
		motion = $"{motionId}",
   		label =  $"{motionType.toString()}"
       	}),
       	Encoding.UTF8,
       	"application/json");
	using HttpResponseMessage response = await httpClient.PatchAsync(apiURL, jsonContent);
	
	if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
	
	return true;
		
}

```


### <p align="center">Equipment</p>

* __connectEquipment(string, int, int):bool__ - This method is supposed to allow the user currently callingg it to connect to the sensors. If the equipment is available then the user should be able to connct to it, otherwise they should be warned of it's unavailability. This method takes as parameters a string and two integers. The string represents the type of equipment, and the integer represent the port and the ip of the sensor. This method returns a bool based on it's success

</br> Ex:

```csharp

public bool connectEquipment(string type, int ip, int port){
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		ip = $"{ip}",
			type = $"{type}",
			port = $"{port}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(sensorsURL + "/connect" , jsonContent);
	
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect
}

```

* __disconnectEquipment():bool__ - This method is supposed to allow the user currently calling it to disconnect from the sensors. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection), or the user should be informed, when trying to call this method, that they need to connect to the equipment first. This method takes, as a parameter, an integer representing the id of the user currently calling in, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool disconnectEquipment(int userId){
		
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		id = $"{userId}"
        	}),
        	Encoding.UTF8,
        	"application/json");	
	HttpResponseMessage response = await client.DeleteAsync(sensorsURL + "/disconnect");
	
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect
}

```

* __collectData(int,enum):bool__ - This method should warn the server that the user that last connected wants to start collecting data. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection), or the user should be informed, when trying to call this method, that they need to connect to the equipment first. After the server is warned this method should be able to retrieve the data being sent to the server every couple of seconds, and use it to update the charts, in order to display it in real time. This method takes as parameters an integer representing the id of the user currently calling the method, and an enum, representing the type of movemente the user intends to collect data for. This method returs a bool based on it's success
</br> Ex:

```csharp

public bool collectData(int userId, enum movementType){
	
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		userID = $"{userId}",
			label = $"{movementType}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(sensorsURL + "/collect/start" , jsonContent);
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	
	this.seIsCollecting(true);
	this.thread = new Thread(getDataLoop(userId, motionId));
	this.thread.Start();
	return true; 	
}

private void getDataLoop(int userId, int motionId)
{
	while (this.isCollecting)
        {
            Motion motion = this.getData(userId, motionId);
            //draw graphs 
            
            Thread.Sleep(2000);
        }
}
```

* __collectDataStop(int):bool__ - This method should warn the server that the user that last connected wants to stop collecting data. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection) and is currently collecting data, or the user should be informed, when trying to call this method, that they need to start collecting data before they can stop data collection. This method should also set the isCollecting bool variable as false in order to stop the device from keeping on requesting data. This method takes as parameter an integer representing the id of the user currently calling the method, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool collectDataStop(int userId){
	
using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		userID = $"{userId}",
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(sensorsURL + "/collect/stop", jsonContent);
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	
	this.IsCollecting(false);
	this.thread.Join();
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

public string getEquipmentStatus(){
	
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

* __getPrediction(int):string__ - This method should allow the user to retrieve prediction that the prediction model makes based on the current data the user is sending it and the data it has sent previously, and that is stored in the data database. This method takes as parameter an integer representing the id of the user currently calling the method and returns a string that includes the current prediction model prediction. In case of failure the method returns null.
</br> Ex:

```csharp
HttpResponse response = await client.getAsync(predictURL + "/" + userId);
	if(response.StatusCode == "404") return null; //Deal with other possible status codes
	
	var jsonResponse = await response.Content.ReadAsStringAsync();		
	JsonNode jsonNode = JsonNode.Parse(jsonResponse);
	
	return jsonNode["prediction"].ToString();
```

* __predictUserMotion(int):string - This method should warn the server that the user that is currently calling this method wants to start receiving predictions. This method should either only be allowed to be called by a user that has collected enough data to base a prediction on, or the user should be informed, when trying to call this method, that they need to collect more data  first. After the server is warned this method should be able to retrieve the predictions being sent to the server, by the prediction model, every couple of seconds, and use it to update a prediction list, in order to display it in real time. This method takes as a parameter an integer representing the id of the user currently calling the method, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool predictUserMotion(int userId){

	//Verify if user has data to base prediction on
	
	using StringContent jsonContent = new(
		JsonSerializer.Serialize(new
        	{
            		id = $"{userId}"
        	}),
        	Encoding.UTF8,
		"application/json");
	
	HttpResponse response = await client.postAsync(predictURL + "/start", jsonContent);
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	
	this.seIsPredicting(true);
	this.thread = new Thread(predictUserMotionLoop(userId));
	this.thread.Start();
	
	return true;
	
}

private void predictUserMotionLoop(int userId)
{
	while (this.getPrediction())
        {
            string prediction = this.predictUserMotion(userId);
            //update list of predictions
            
            Thread.Sleep(2000);
        }
}
```

* __predictUserMotionLoopStop(int):bool__ - This method should warn the server that the user that is currently calling this method wants to stop receiving prediction from the prediction model. This method should either only be allowed to be called by users that previously called the predictUserMotion method, and were successful, or should warn the user, when trying to call this method, that they need to start receiving predictions before they can call it. This method should set the isPredicting bool variable as false in order to stop the device from keeping on requesting more predictions. This method takes as parameter an integer representing the id of the user currently calling the method, and returns a bool based on it's success.

</br> Ex:

```csharp

public bool predictUserMotionLoopStop(int userID){
	
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		userID = $"{userId}",
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(predictURL + "/predict/stop", jsonContent);
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	
	this.IsPredicting(false);
	this.thread.Join();
	return true;
}
```

* __resetModel(int):bool__ - This method should allow the user to reset their personal predition model. This method should either only be allowed to be called by a user that as collected enough data to have their own prediction model (instead of the general prediction model available to all users), or the user should be informed, when trying to call this method, that they don't have a prediction model to reset. This method takes an integer as a paramenter representing the id of the user currently calling the method, and returns a bool based on it's success.
</br> Ex:

```csharp

public bool resetModel(int userId){
	HttpResponse response = await client.getAsync(predictURL + "/" + userId + "/reset");
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	return true;
}
```

### <p align="center">Graphs</p>

* __draw(Motion) : bool__ - This method should draw the graphs created to display the data collected by the sensors and retrieved from the server during collectData. It can also be used to draw graphs based on previous sessions of data collection. This method takes as a parameter a Motion instance, and returns a bool based on the success of the method.

