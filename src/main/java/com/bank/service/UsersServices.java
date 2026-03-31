package com.bank.service;

import com.bank.entity.Accounts;
import com.bank.entity.Users;

public interface UsersServices 
{

	Accounts save(Users user);

	boolean validateUser(String userId, String password);

	String getUserName(String userId);

	Users getDetails(String userId);
   
}
