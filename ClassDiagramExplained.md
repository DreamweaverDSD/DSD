
# <p align="center" >Class Diagram</p>

## Diagram
![Class Diagram](https://i.imgur.com/XgE6YUW.png)

## Method Explanation
### <p align = "center">User</p>


* __setUserNameAPI(string)__ : bool - This method should make a PUT/PATCH call to the user database API in order to add a user's name. This method takes as parameter a string storing the value the user wrote in the username textbox.
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
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		if((int)response.StatusCode==404)return false;; //Deal with patch failure (deal with other status codes)
		
		return true;
	}
 ```



* __updatePassword(string,string)__ : bool- This method is used to update the user's password when they're already logged into their account. The user inserts their previous password, and the password they wish to change it to. This method should make a GET call to get the hash of the current user password, compare it to the hash of the text in the previous user password text box, and if they match it should make a PUT/PATCH call to the user database API changing the previous password to the new one(the hash of the text in the new password text box). This method takes as parameter two strings, one storing the value the user wrote in the previousePassword textbox, and the other storing the value the user wrote in the newPassword textbox.
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
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
	
		return true;
	}
 ```

* __getUserGuide():string__ - !!CONFUSED!! 



* __setBirthdayAPI(Date)__ : bool - This method should make a PUT/PATCH call to the user database API in order to add a user's birthday. This method takes as parameter a Date storing the value the user  inserted as their birthday.
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
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
	
		return true;
	}
```

* __setPhoneNumber(string)__ : bool- This method should make a PUT/PATCH call to the user database API in order to add a user's phone number. This method takes as parameter a string storing the value the user wrote in the phoneNumber textbox.
</br> Ex:

```csharp
public bool setPhoneNumberAPI(string phonenumber)
	{
		//validate phone number(Could be made into a method of it's own)
		//It ins't possible to distinguish user error from API error with a bool, so maybe we should verify if date is acceptable in the window code
		
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		phoneNumber =  $"{phonenumber}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
	
		return true;
	}
```

* __setEmail(string)__ : bool - Set the user's email variable to the text in the email text box of a successful login attempt. This method takes as parameter a string storing the value the user wrote in the email textbox
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
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		if((int)response.StatusCode==404) return false //Deal with patch failure (deal with other status codes)
	
		return true;
	}
```


### <p align="center">Authentication</p>

* __login(string, string):user__ - This method should make a GET call to the user database API in order to check if a user with the given email exists. If an entry for that email does exist, the method should then use the method getPassword() to check the current password from the user database and compare it to the hash of the password written by the user in the password text box. If the passwords match the user's identity is verified and he should be logged in, otherwise they should be denied access to the account. This method takes as parameter two strings, one storing the value the user wrote in the email textbox in the login view, and the other one storing the value they wrote in the password textbox in the login view.
</br> Ex:

```csharp
public static User login(string email, string password)
	{
		User user = new User();
		
	
		using HttpResponseMessage response = httpclient.GetAsync(userURL + "?email=" + email);
		if(response.StatusCode == "404")//We could verify for more status codes, displaying different messages
		{
			//warn user login failed
			return null;
		}
		
		var jsonResponse = await response.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		string apiPassword = jsonNode["password"].ToString();
		if(apiPassword != password) return null; //warn user login failed - return NULL
		user.setLogged();
		user.setId(Convert.ToInt32(jsonNode["id"]));
		user.setEmail(jsonNode["email"]);
		user.setPassword(jsonNode["password"]);
		user.setPhoneNumber(Convert.ToInt32(jsonNode["phoneNumber"]));
		user.setUserName(jsonNode["userName"]);
		string birthday=jsonNode["birthday"];//verify if is null
		user.setBirthday(SimpleDateFormat("dd/MM/yyyy").parse(birthday););
		
	
		
		return user;
	}
```

* __logout(User)__ : bool - This method is called when the user wishes to logout of their account, changing the user's bool variable Logged to false. This method takes as parameter a User, representing the user currently calling the method.
</br> Ex:

```csharp
public static bool logout(User user)
	{
		if(!user.getLogged()) return false
		/*user.setLogged(); // if fails return false 
		user.setId(0);//Some representation of no user
		user.setEmail(NULL);
		user.setPassword(NULL);
		user.setEmail(NULL);
		user.setuserName(NULL);
		user.setBirthday(NULL);*/
		
		//Delete user
		
		return true
	}
```

* __register(string, string):user__ - This method should make a GET call to the user database API in order to check if the email the user is currently attempting to create a new account with is already in use or not. If the email is available, the method should make a POST call to the user database API, in order to create a new user entry with the email and password in question. This method takes as parameter two strings, one storing the value the user wrote in the email textbox, and the other one storing what they wrote in the password textbox in the register view.

</br> Ex:

```csharp
public static User register(string email, string password)
	{
		//creating user with email and password
		User user = new User(email,password);
		
	
    		using HttpResponseMessage response = await httpClient.PostAsync(userURL, user);
    		if((int)response.StatusCode==404) return null //Deal with patch failure (deal with other status codes)
	
		using HttpResponseMessage response = httpclient.GetAsync(userURL + "?email=" + email);		
		var jsonResponse = await response.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		user.setId(Convert.ToInt32(jsonNode["id"]));
		user.setLogged();
		
		return user;
	}
```

### <p align="center">DataManagement</p>

* __getData(int, Motion motion):bool__ - This method is used to retrieve, from the data database, the data collected by the user currently calling the method. This method should make a GET call to the data database API and generate a List of Data objects, returning it. This method takes as a parameter the id of the user currently calling the method.
</br> Ex:

```csharp
public bool getData(int id, Motion motion)//user id or what may be necessary to identify the data
{
	HttpResponse response = await client.getAsync(dataURL+'/'+ id );
	
	
	if(response.IsSuccessStatusCode){
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
		return true
	}
	//return null;
	return false;
}


```

* __discardData(int):bool__ - This method should delete the data stored in the data database associated with the user currently calling the method. It makes a delete call to the data database API. This method should make a DELETE call to the data database API and return a status code. 
</br> Ex:

```csharp

public bool discardData(int userId){
	//the data linked to the user id will be deleted
	HttpResponse response = await client.DeleteAsync(dataUrl + "/" + userId);
	return response.IsSuccessStatusCode;
}

```


* __ChangeLabel(string)__ - !!CONFUSED!!


### <p align="center">PredictionModel</p>

* __predictUserMotion(int):string - This method should retrieve for the user, the prediction the prediction model is capable of generating based on previous user data stored in the data database. This method should take the as a parameter an int representing the id of the user currently calling the method, and should make a GET call to return the prediction the prediction model makes for this specific user.
</br> Ex:

```csharp

public string predictUserMotion(int userId){

	//Verify if user has data to base prediction on
	
	HttpResponse response = await client.getAsync(predictURL + "/" + userId);
	if(response.StatusCode == "404") return null; //Deal with other possible status codes
	
	var jsonResponse = await response.Content.ReadAsStringAsync();		
	JsonNode jsonNode = JsonNode.Parse(jsonResponse);
	
	return jsonNode["prediction"].ToString();
	
}
```

* __resetModel(int):bool__ - This method should allow the user to reset their personal predition model. This method should either only be allowed to be called by a user that as collected enough data to have their own prediction model (instead of the general prediction model available to all users), or the user should be informed, when trying to call this method, that they don't have a prediction model to reset.
</br> Ex:

```csharp

public bool resetModel(int userId){
	HttpResponse response = await client.getAsync(predictURL + "/" + userId + "/reset");
	if(response.StatusCode == "404") return false; //Deal with other possible status codes
	return true;
}
```

### <p align="center">Equipment</p>

* __connectEquipment(int,string):bool__ - This method is supposed to allow the user currently calling it to connect to the sensors. With a limited number of equipment available the we must make an API posr request sending the user's Id and the type of data they are planning of collecting. If the equipment is availbale our user should be able to connect to it, otherwise they should be warned of it's unavailability. This method takes an int and a string as parameters, with the integer representing the id of the user currently calling the method, and the string representing the type of movement the user plans to collect data for.
</br> Ex:

```csharp

public bool connectEquipment(int userId, string movementType){
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		userID = $"{userId}",
			movementType = $"{movementType}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(sensorsURL + "/connect" , jsonContent);
	
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect
}

```

* __disconnectEquipment():bool__ - This method is supposed to allow the user currently calling it to disconnect from the sensors. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection), or the user should be informed, when trying to call this method, that they need to connect to the equipment first. T
</br> Ex:

```csharp

public bool disconnectEquipment(){
		
	HttpResponseMessage response = await client.DeleteAsync(sensorsURL + "/connect");
	
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect
}

```

* __collectData(int):bool__ - This method should warn the server that the user that last connected wants to start collecting data for the movement type they specified on connection. The method should send the id of the user currently calling it, and a "start" so that data collection can begin. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection), or the user should be informed, when trying to call this method, that they need to connect to the equipment first. This method takes as parameter and integer representing the id of the user currently calling the method.
</br> Ex:

```csharp

public bool collectData(int userId){
	
	using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		userID = $"{userId}",
        	}),
        	Encoding.UTF8,
        	"application/json");
		
	HttpResponseMessage response = await client.PostAsync(sensorsURL + "/collect/start" , jsonContent);
	
	//Receive real time data returned by server
	
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect	
}
```



* __collectDataStop(int):bool__ - This method should warn the server that the user that last connected wants to stop collecting data for the movement type they specified on connection. The method should send the id of the user currently calling it, and an "end" so that data collection can stop. This method should either only be allowed to be called by a user that successfully connected to the equipment (it was available and there were no errors on either the user or server end when performing the connection) and is currently collecting data, or the user should be informed, when trying to call this method, that they need to start collecting data before they can stop data collection. This method takes as parameter an integer representing the id of the user currently calling the method.
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
	collecting=false;
	return response.IsSuccessStatusCode //Deal with the possibility of failure to connect	
}
```


* __getEquipmentStatus():string__ - This method should retrieve the status of the sensors. The method makes a get call to the sensor API, receiving a JsonArray with each entry representing a sensor. The method then parses the array, retreiving the status of each sensor and creating a string that is then returned.
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

* __getEquipmentInfo():string__ - This method should retrieve information about the sensors. The method makes a get call to the sensor API, receiving a JsonArray with each entry representing a sensor. The method then parses the array, retreiving the all the relevant information of each senso, creating a string of information that is then returned and can be presented.
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
