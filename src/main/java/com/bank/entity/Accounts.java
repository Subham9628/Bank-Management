package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Accounts 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long accountNo;
   private String userId;
   private double amount;
   
   public Accounts()
   {
	
   }
   public long getAccountNo() {
	return accountNo;
   }
   public void setAccountNo(long accountNo) {
	this.accountNo = accountNo;
   }
   public String getUserId() {
	return userId;
   }
   public void setUserId(String userId) {
	this.userId = userId;
   }
   public double getAmount() {
	return amount;
   }
   public void setAmount(double amount) {
	this.amount = amount;
   }
   
   
}
