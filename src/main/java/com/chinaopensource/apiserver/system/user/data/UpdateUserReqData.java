package com.chinaopensource.apiserver.system.user.data;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UpdateUserReqData {

    @NotNull
    int id;
    @NotNull
    String userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "UpdateUserReqData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
