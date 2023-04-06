
# <p align="center" >Class Diagram</p>

## Diagram
![Class Diagram](https://i.imgur.com/vKeo2Cu.png)

## Method Explanation
### <p align = "center">User</p>

* __getUserName():string__ - This method should make a GET call to the user database API in order to retreive the user's name. 
</br> Ex:

```csharp
public string getUserName()
	{	
		return httpclient.GetStringAsync(userUrl + "/" + user.getEmail() + "/username");
	}
```
* __setUserName()__ - This method should make a PUT/PATCH call to the user database API in order to add a user's name. 
</br> Ex:

```csharp
public void setUserName()
	{
		httpclient.PutAsJsonAsync(userURL + "/" + user.getEmail() + "/username", userNameTextBox.Text);
	}
 ```

* __getPassword():string__ - This method should make a GET call to the useer databasee API in order to retreive the user's password's hash.
</br> Ex:

```csharp
public string getPassword()
{
	return httpclient.GetSTringAsync(userURL + "/" + user.getEmail() + "/password";
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
		httpclient.PutAsJsonAsync(userURL + "/" + user.getEmail() + "/password", textBoxPreviousPassword);
	}
 ```

* __getUserGuide():string__ - !!CONFUSED!! 

* __getBirthday():Date__ - This method should make a GET call to the user database API in order to retreive the user's birthday.
</br> Ex:

```csharp
public Date getBirthday()
{
	string bdayString httpclient.GetStringAsync(userURL + "/" + user.getEmail() + "/birthday";
	Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(bdayString);
	return birthday;
}
```

* __setBirthday()__ - This method should make a PUT/PATCH call to the user database API in order to add a user's birthday.
</br> Ex:

```csharp
public void setBirthday()
	{
		if(getBirthday() != NULL)
		{
			//Warn user that they can't change birthday once it's set
			return;
		}
		if(birthdayDatePicker.Date < Date.Today()) //or any other restrictions the birthday might have(Could be made into a method of it's own)
		{
			//Warn user date is not acceptable
			return;
		}
		httpclient.PutAsJsonAsync(userURL + "/" + user.getEmail() + "/birthday", birthdayDatePicker.Date);
	}
```

* __setPhoneNumber()__ - This method should make a PUT/PATCH call to the user database API in order to add a user's phone number.
</br> Ex:

```csharp
public void setPhoneNumber()
	{
		//validate phone number(Could be made into a method of it's own)
		httpclient.PutAsJsonAsync(userURL + "/" + user.getEmail() + "/phoneNumber", phoneNumberTextBox.Text);	
	}
```
* __getEmail():string__ - return value in email variable
</br> Ex:

```csharp
public void getEmail()
	{
		return this.email;
	}
```

* __setEmail(string)__ - Set the user's email variable to the text in the email text box of a successful login attempt
</br> Ex:

```csharp
public void setEmail(string email)
	{
		this.email = email;
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

* __login()__ - This method calls the login method in authentication, and the setLogged method deppending on the value returned
</br> Ex:

```csharp
public void login()
	{
		if(getLogged()) return;
		Authentication auth = new Authentication();
		if(auth.login(emailTextBox.Text, passwordTextBox.Text)) 
		{
			setLogged();
			setEmail(emailTextBox.Text);
			return;
		}
		else return;
	}
```

* __logout()__ - This method is called when the user wishes to logout of their account, calling the method setLogged()
</br> Ex:

```csharp
public void logout()
	{
		if(!getLogged) return
		setLogged();
		setEmail("");
	}
```

* __register()__ - This method calls the register method in authentication and setLogged method depending on the value returned
</br> Ex:

```csharp
public void register()
	{
		Authentication auth = new Authentication();
		if(auth.register(emailTextBox.Text, passwordTextBox.Text)
		{
			setEmail(emailTextBox.Text);
		}
		else return;
	}
```

### <p align="center">Authentication</p>

* __login(string, string):bool__ - This method should make a GET call to the user database API in order to check if a user with the given email exists. If an entry for that email does exist, the method should then use the method getPassword() to check the current password from the user database and compare it to the hash of the password written by the user in the password text box. If the passwords match the user's identity is verified and he should be logged in, otherwise they should be denied access to the account
</br> Ex:

```csharp
public bool login(string email, string password)
	{
		if(httpclient.GetStringAsync(userURL + "?email=" + email).Status =="404")//We could verify for more status codes, displaying different messages
		{
			//warn user login failed
			return false;
		}
		if(httpclient.GetStringAsync($"{userURL}/{email}/password).Result == password) return true;
		else return false;		
	}
```

* __register(string, string):bool__ - This method should make a GET call to the user database API in order to check if the email the user is currently attempting to create a new account with is already in use or not. If the email is available, the method should make a POST call to the user database API, in order to create a new user entry with the email and password in question


