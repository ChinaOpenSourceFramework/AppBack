package com.chinaopensource.apiserver.system.user.data;

public class UserData {
	
	int id;
	String loginName;
	String userName;
	String password;
	int age; 
	String phone;
	String photo;
	String address;
	String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserData{" +
				"id=" + id +
				", loginName='" + loginName + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				", phone='" + phone + '\'' +
				", photo='" + photo + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
