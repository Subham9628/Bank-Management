package com.bank.service;

import com.bank.entity.Users;

public interface UsersServices 
{

	void save(Users user);

	boolean validateUser(String userId, String password);

	String getUserName(String userId);
   
}
