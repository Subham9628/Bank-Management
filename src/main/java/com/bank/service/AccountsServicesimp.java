package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Accounts;
import com.bank.entity.DateAndTime;
import com.bank.entity.TransactionInfo;
import com.bank.repository.AccountRepository;

@Service
public class AccountsServicesimp implements AccountsServices
{
    @Autowired
    private AccountRepository accountRepo;
	@Override
	public Accounts save(Accounts account) 
	{
		return accountRepo.save(account);
	}
	@Override
	public long getAccountNo(String userId) 
	{
		Accounts account=accountRepo.findByUserId(userId);
		return account.getAccountNo();
	}
	
	public double fetchBalance(long accountNo) 
	{
		Accounts account=accountRepo.findById(accountNo).orElse(null);
		return account.getAmount();
	}
	@Override
	public TransactionInfo successDep(long accountNo, double money) 
	{
		Accounts account=accountRepo.findById(accountNo).orElse(null);
	    double amount=account.getAmount()+money;
	    account.setAmount(amount);
	    accountRepo.save(account);
	    TransactionInfo info=new TransactionInfo();
	    info.setAmount(money);
	    info.setDate(new DateAndTime().getDate());
	    info.setFromAccount(accountNo);
	    info.setToAccount("self");
	    info.setType("Credit");
	    info.setTime(new DateAndTime().getTime());
	    return info;
	}
}
