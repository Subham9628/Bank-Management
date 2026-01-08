package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Accounts;
import com.bank.repository.AccountRepository;

@Service
public class AccountsServicesimp implements AccountsServices
{
    @Autowired
    private AccountRepository repo;
	@Override
	public Accounts save(Accounts account) 
	{
		return repo.save(account);
	}
	
  
}
