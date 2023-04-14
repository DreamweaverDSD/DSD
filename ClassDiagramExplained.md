
# <p align="center" >Class Diagram</p>

## Diagram
![Class Diagram](https://i.imgur.com/2RRNoZM.png)

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
		user.setEmail(Convert.ToInt32(jsonNode["phoneNumber"]));
		user.setuserName(jsonNode["userName"]);
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

* __getData(int):List<Data>__ - This method is used to retrieve, from the data database, the data collected by the user currently calling the method. This method should make a GET call to the data database API and generate a List of Data objects, returning it. This method takes as a parameter the id of the user currently calling the method.
</br> Ex:

```csharp
public static List<Data> GetData(int id)//user id or what may be necessary to identify the data
{
	HttpResponse response = await client.getAsync(dataURL+'/'+id);
	
	
	if(response.IsSuccessStatusCode){
	string json = await response.Content.ReadAsStringAsync();

    List<Data> dataList = new List<Data>();

    JArray sensorDataArray = JsonConvert.DeserializeObject<JArray>(json);

    foreach (JObject sensorData in sensorDataArray)
    {
        double timestamp = sensorData["timestamp"].Value<double>();

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
        }
    }

    return dataList;
}
return null;
}


```

* __DiscardData(int):bool__ - This method should delete the data stored in the data database associated with the user currently calling the method. It makes a delete call to the data database API. This method should make a DELETE call to the data database API and return a status code. 
</br> Ex:

```csharp

public static bool DiscardData(int userId){
	//the data linked to the user id will be deleted
	HttpResponse response = await client.DeleteAsync(dataUrl + "/" + userId);
	return response.IsSuccessStatusCode;
	
}

```


* __ChangeLabel(string)__ - !!CONFUSED!!


### <p align="center">PredictionModel</p>

* __PredictUserMotion(int):string - This method should retrieve for the user, the prediction the prediction model is capable of generating based on previous user data stored in the data database. This method should take the as a parameter an int representing the id of the user currently calling the method, and should make a GET call to return the predicion the prediction model makes for this specific user. Before making this call we should make sure the user has data (enough) associated with it's id for the predicion model to base it's prediction on.
</br> Ex:

```csharp

public static string ConnectEquipment(int userId){

	//Verify if user has data to base prediction on
	
	HttpResponse response = await client.getAsync(predictURL + "/" + userId);
	if(response.StatusCode == "404") return null; //Deal with other possible status codes
	
	var jsonResponse = await response.Content.ReadAsStringAsync();		
	JsonNode jsonNode = JsonNode.Parse(jsonResponse);
	
	return jsonNode["prediction"].ToString();
	
}
```

* __ResetModel(int):bool__ - !!CONFUSED!!
</br> Ex:

```csharp

public static bool ResetModel(int userId){
	
}
```

### <p align="center">Equipment</p>

* __ConnectEquipment(int):bool__ - !!CONFUSED!!
</br> Ex:

```csharp

public static bool ConnectEquipment(int userId){

	
}

```





