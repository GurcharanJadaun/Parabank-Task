package apiObjects;


import java.util.HashMap;

import io.restassured.path.json.JsonPath;

public class UserData extends AccountInformation{
	String firstName, lastName, address, city, state, zipCode, phoneNo, SSN, userName, password;
	
	public UserData(JsonPath userData) {
		firstName = userData.get("results[0].name.first");
		lastName = userData.get("results[0].name.last");
		address = "Street " + userData.get("results[0].location.street.number") +
				  ", "+ userData.get("results[0].location.street.name");
		city = userData.get("results[0].location.city");
		state = userData.get("results[0].location.state");
		zipCode = userData.get("results[0].location.postcode").toString();
		phoneNo = userData.get("results[0].phone");
		SSN = userData.get("results[0].id.value");
		userName = userData.get("results[0].login.username");
		password = "Orange@11";
	}
	
	public void display() {
		System.out.println(firstName+ "\n" +lastName+ "\n" +address+ "\n" +city+ "\n" +state+ "\n" +zipCode+ 
				"\n" +phoneNo+ "\n" +SSN+ "\n" +userName+ "\n" +password);
		displayAccountInfo();
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getSSN() {
		return SSN;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getPassword() {
		return password;
	}
	 
	public void setFirstName(String data) {
		firstName = data;
	}
	
	public void setLastName(String data) {
		lastName = data;
	}
	
	public void setState(String data) {
		state = data;
	}
	
	public void setCity(String data) {
		city = data;
	}
	
	public void setAddress(String data) {
		address = data;
	}
	
	public void setUserName(String data) {
		userName = data;
	}
	
	public void setSSN(String data) {
		SSN = data;
	}
	
	public void setPhoneNo(String data) {
		phoneNo = data;
	}
	
	public void setZipCode(String data) {
		zipCode = data;
	}
	
	public void setPassword(String data) {
		password = data;
	}

	

}
