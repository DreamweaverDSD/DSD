
# <p align="center" >Class Diagram</p>

## Diagram
![Class Diagram](https://i.imgur.com/3SoQI7l.png)

## Method Explanation
### <p align = "center">USER</p>

getUserName():string ->This method should make a GET call to the user database API in order to retreive the user's username. 
</br> Ex:
```csharp
public string getUserName()
	{	
		return httpclient.GetStringAsync(userUrl + "/" + user.getEmail() + "/username");
	}
```
setUserName() ->This method should make a PUT/PATCH call to the user database API in order to add a user's name. 
</br> Ex:
```csharp
public void setUserName()
	{
		httpclient.PutAsJsonAsync(userURL + "/" + user.getEmail() + "/username", userNameTextBox.Text);
	}
 ```

getPassword():string ->This method should make a GET call to the useer databasee API in order to retreive the user's password's hash.
</br> Ex:
```csharp
public string getPassword()
{
	return httpclient.GetSTringAsync(userURL + "/" + user.getEmail() + "/password";
}
```

updatePassword() ->This method is used to update the user's password when they're already logged into their account. The user inserts their previous password, and the password they wish to change it to. This method should make a GET call to get the hash of the current user password, compare it to the hash of the text in the previous user password text box, and if they match it should make a PUT/PATCH call to the user database API changing the previous password to the new one(the hash of the text in the new password text box).
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

getUserGuide():string -> ## !!CONFUSED!! 

getBirthday():Date ->This method should make a GET call to the user database API in order to retreive the user's birthday.
</br> Ex:
```csharp
public Date getBirthday()
{
	string bdayString httpclient.GetSTringAsync(userURL + "/" + user.getEmail() + "/birthday";
	Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(bdayString);
	return birthday;
}
```

setBirthday() ->This method should make a PUT/PATCH call to the user database API in order to add a user's birthday.
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
setPhoneNumber() ->This method should make a PUT/PATCH call to the user database API in order to add a user's phone number.
</br> Ex:
```csharp
public void setPhoneNumber()
	{
		//validate phone number(Could be made into a method of it's own)
		httpclient.PutAsJsonAsync(userURL + "/" + user.getEmail() + "/phoneNumber", phoneNumberTextBox.Text);	
	}
```
getEmail():string ->return value in email variable
</br> Ex:
```csharp
public void getEmail()
	{
		return this.email;
	}
```

