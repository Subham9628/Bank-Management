package com.bank.service;

import com.bank.entity.Accounts;

public interface AccountsServices 
{

	Accounts save(Accounts account);

	long getAccountNo(String userId);


}
