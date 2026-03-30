package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="transactionInfo")
public class TransactionInfo 
{
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acc_seq")
   @SequenceGenerator(
           name = "acc_seq",
           sequenceName = "account_sequence",
           initialValue = 1000000000,
           allocationSize = 1)
   private long tid;
   private long fromAccount;
   private String date;
   private String time ;
   private double amount;
   private String type;
   private String toAccount;
   public  long getFromAccount() {
	return fromAccount;
   }
   public long getTid() {
	return tid;
}
   public void setTid(long tid) {
	this.tid = tid;
   }
   public void setFromAccount(long fromAccount) {
	this.fromAccount = fromAccount;
   }
   public String getDate() {
	return date;
   }
   public void setDate(String date) {
	this.date = date;
   }
   public String getTime() {
	return time;
   }
   public void setTime(String time) {
	this.time = time;
   }
   public double getAmount() {
	return amount;
   }
   public void setAmount(double amount) {
	this.amount = amount;
   }
   public String getType() {
	return type;
   }
   public void setType(String type) {
	this.type = type;
   }
   public String getToAccount() {
	return toAccount;
   }
   public void setToAccount(String toAccount) {
	this.toAccount = toAccount;
   }
  
   
}
   