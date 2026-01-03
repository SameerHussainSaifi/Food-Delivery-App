package com.food.Model;

public class User {
	
private int userId;
private String userName;
private String password;
private String email;
private String address;
private String role;
private long phone;

public User() {
	
}

public User(int userId, String userName, String password, String email, String address, String role, long phone) {
	
	this.userId = userId;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.address = address;
	this.role = role;
	this.phone=phone;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public void setPhone(long phone) {
	this.phone=phone;
}

public long getPhone() {
	return phone;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
			+ ", address=" + address + ", role=" + role + ", phone=" + phone + "]";
}


}
