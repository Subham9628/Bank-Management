package com.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users 
{
   @Id
   private String userId;
   private String password;
   private String fullName;
   private String fatherName;
   @Enumerated(EnumType.STRING)
   private Gender gender;
   private String dataOfBirth;
   private String emailId;
   @Column(length = 10)
   private String mobileNo;
   private String address;
   public String getUserId() {
	return userId;
   }
   public void setUserId(String userId) {
	this.userId = userId;
   }
   public String getPassword() {
	return password;
   }
   public void setPassword(String password) {
	this.password = password;
   }
   public String getFullName() {
	return fullName;
   }
   public void setFullName(String fullName) {
	this.fullName = fullName;
   }
   public String getFatherName() {
	return fatherName;
   }
   public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
   }
   public Gender getGender() {
	return gender;
   }
   public void setGender(Gender gender) {
	this.gender = gender;
   }
   public String getDataOfBirth() {
	return dataOfBirth;
   }
   public void setDataOfBirth(String dataOfBirth) {
	this.dataOfBirth = dataOfBirth;
   }
   public String getEmailId() {
	return emailId;
   }
   public void setEmailId(String emailId) {
	this.emailId = emailId;
   }
   public String getMobileNo() {
	return mobileNo;
   }
   public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
   }
   public String getAddress() {
	return address;
   }
   public void setAddress(String address) {
	this.address = address;
   }
   
}
