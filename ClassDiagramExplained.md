
# <p align="center" >Class Diagram</p>

## Diagram
![Class Diagram](https://i.imgur.com/Rq5HSjz.png)

## Method Explanation
### <p align = "center">User</p>

* __getUserName():string__ - This method should make a GET call to the user database API in order to retreive the user's name. 
</br> Ex:

```csharp
public string getUserName()
	{	
		using HttpResponseMessage response = await httpclient.GetAsync(userUrl + "/" + user.getId() + "/username");
		response.EnsureSuccessStatusCode(); //Deal with get failure
		var jsonResponse = await response.Content.ReadAsStringAsync();
		return jsonResponse;
	}
```
* __setUserName(string)__ - This method should make a PUT/PATCH call to the user database API in order to add a user's name. 
</br> Ex:

```csharp
public void setUserName(strin name)
	{
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		username = $"{userNameTextBox.Text}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		response.EnsureSuccessStatusCode(); //Deal with patch failure
	}
 ```

* __getPassword():string__ - This method should make a GET call to the useer databasee API in order to retreive the user's password's hash.
</br> Ex:

```csharp
public string getPassword()
{
	using HttpResponseMessage response= httpclient.GetAsync(userURL + "/" + user.getId() + "/password");
	response.EnsureSuccessStatusCode(); //Deal with get failure
	var jsonResponse = await response.Content.ReadAsStringAsync();
	return jsonResponse;
}
```

* __updatePassword()__ - This method is used to update the user's password when they're already logged into their account. The user inserts their previous password, and the password they wish to change it to. This method should make a GET call to get the hash of the current user password, compare it to the hash of the text in the previous user password text box, and if they match it should make a PUT/PATCH call to the user database API changing the previous password to the new one(the hash of the text in the new password text box).
</br> Ex:

```csharp
public void updatePassword()
	{
		byte[] passwordBytes = Encoding.UTF8.GetBytes(previousPasswordTextBox.Text);
            	byte[] passwordHashBytes = SHA256.HashData(passwordBytes);//whatever hasing algorithm is used for the passwords in database
		string textBoxPreviousPassword = BitConverter.ToString(passwordHashBytes)
		if(user.getPassword() !=  textboxPreviousPassword)
		{
			//Warn user wrong Password
			return;
		} 

		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		password =  $"{textBoxNewPassword.Text}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		response.EnsureSuccessStatusCode(); //Deal with patch failure
	}
 ```

* __getUserGuide():string__ - !!CONFUSED!! 

* __getBirthday():Date__ - This method should make a GET call to the user database API in order to retreive the user's birthday.
</br> Ex:

```csharp
public Date getBirthday()
{
	using HttpResponseMessage response = httpclient.GetAsync(userURL + "/" + user.getId() + "/birthday");
	response.EnsureSuccessStatusCode(); //Deal with get failure
	var jsonResponse = await response.Content.ReadAsStringAsync();
	Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(jsonResponse);
	return jsonResponse;
}
```

* __setBirthday()__ - This method should make a PUT/PATCH call to the user database API in order to add a user's birthday.
</br> Ex:

```csharp
public void setBirthday()
	{

		if(birthdayDatePicker.Date < Date.Today()) //or any other restrictions the birthday might have(Could be made into a method of it's own)
		{
			//Warn user date is not acceptable
			return;
		}
		
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		birthday =  $"{birthdayDatePicker.Date.toString()}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		response.EnsureSuccessStatusCode(); //Deal with patch failure
	}
```

* __setPhoneNumber()__ - This method should make a PUT/PATCH call to the user database API in order to add a user's phone number.
</br> Ex:

```csharp
public void setPhoneNumber()
	{
		//validate phone number(Could be made into a method of it's own)
		
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		phoneNumber =  $"{phoneNumberTextBox.Text}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		response.EnsureSuccessStatusCode(); //Deal with patch failure
	}
```
* __getEmail():string__ - return value in email variable
</br> Ex:

```csharp
public void getEmail()
	{
		using HttpResponseMessage response = httpclient.GetAsync(userURL + "/" + user.getId() + "/email");
		response.EnsureSuccessStatusCode(); //Deal with get failure
		var jsonResponse = await response.Content.ReadAsStringAsync();
		return jsonResponse;
	}
```

* __setEmail()__ - Set the user's email variable to the text in the email text box of a successful login attempt
</br> Ex:

```csharp
public void setEmail()
	{
		JsonSerializer.Serialize(new
        	{
            		email =  $"{emailTextBox.Text}"
        	}),
        	Encoding.UTF8,
        	"application/json");
		using HttpResponseMessage response = await httpClient.PatchAsync(userURL + "/" + user.getId(), jsonContent);
		response.EnsureSuccessStatusCode(); //Deal with patch failure
	}
```

* __getLogged():bool__ - get the value stored in the user's bool variable logged
</br> Ex:

```csharp
public bool getLogged()
	{
		return logged;
	}
```

* __setLogged()__ - change the value of bool variable logged
</br> Ex:

```csharp
public void setLogged()
	{
		logged = !logged;
	}
```

* __getId():int__ - returns the int value in the user's id attribute
</br> Ex:

```csharp
public int getId()
{
	return id;
}
```

* __setId(int)__ - set the user's id variable to the id value found in the corresponding entry in the user database 
</br> Ex:

```csharp
public void setId(int id)
{
	this.id=id;
}
```


### <p align="center">Authentication</p>

* __login(string, string):user__ - This method should make a GET call to the user database API in order to check if a user with the given email exists. If an entry for that email does exist, the method should then use the method getPassword() to check the current password from the user database and compare it to the hash of the password written by the user in the password text box. If the passwords match the user's identity is verified and he should be logged in, otherwise they should be denied access to the account
</br> Ex:

```csharp
public static User login(string email, string password)
	{
		User user = new User();
	
		using HttpResponseMessage response = httpclient.GetAsync(userURL + "?email=" + email);
		if(response.StatusCode == "404")//We could verify for more status codes, displaying different messages
		{
			//warn user login failed
			return false;
		}
		
		var jsonResponse = await response.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		string apiPassword = jsonNode["password"].ToString();
		if(apiPassword != password) return; //warn user login failed - return NULL
		user.setLogged();
		user.setId(Convert.ToInt32(jsonNode["id"]));	
		
		return user;
	}
```

* __logout()__ - This method is called when the user wishes to logout of their account, changing the user's bool variable Logged to false
</br> Ex:

```csharp
public static bool logout(User user)
	{
		if(!user.getLogged()) return false
		user.setLogged(); // if fails return false 
		setId(0);//Some representation of no user
		return true
	}
```

* __register(string, string):user__ - This method should make a GET call to the user database API in order to check if the email the user is currently attempting to create a new account with is already in use or not. If the email is available, the method should make a POST call to the user database API, in order to create a new user entry with the email and password in question
public static user
</br> Ex:

```csharp
public static User register(string email, string password)
	{
		User user = new User();
	
		using StringContent jsonContent = new(
        	JsonSerializer.Serialize(new
        	{
            		email = ${email},
            		password = ${password},
            		birthday = null,
            		phoneNumber = null,
			//Other attributes depending on the database
        	}),
        	Encoding.UTF8,
        	"application/json");

    		using HttpResponseMessage response = await httpClient.PostAsync(userURL, jsonContent);
    		response.EnsureSuccessStatusCode()//Deal with patch failure - return NULL
	
		using HttpResponseMessage response = httpclient.GetAsync(userURL + "?email=" + email);		
		var jsonResponse = await response.Content.ReadAsStringAsync();		
		JsonNode jsonNode = JsonNode.Parse(jsonResponse);
		user.setId(Convert.ToInt32(jsonNode["id"]));
		user.setLogged();
		
		return user;
	}
```

