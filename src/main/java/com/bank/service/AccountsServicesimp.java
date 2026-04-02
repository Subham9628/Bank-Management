package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Accounts;
import com.bank.entity.TransactionInfo;
import com.bank.entity.Users;
import com.bank.repository.AccountRepository;

@Service
public class AccountsServicesImp implements AccountsServices
{
    @Autowired
    private AccountRepository accountRepo;
   
    @Autowired
    private TransactionInfoServices trnService;
	@Override
	public Accounts save(Users user) 
	{
		Accounts account=new Accounts();
		account.setAmount(0);
		account.setUserId(user.getUserId());
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
	    TransactionInfo info=trnService.addInfo(accountNo, money,"Credit");
	    info.setAmount(money);
	    return info;
	}
	@Override
	public TransactionInfo successWithdraw(long accountNo, double money) 
	{
		Accounts account=accountRepo.findById(accountNo).orElse(null);
		double amount=account.getAmount();
		if(money<=amount)
		{
		   TransactionInfo info=trnService.addInfo(accountNo,money,"Debit");
		   account.setAmount(amount-money);
		   accountRepo.save(account);
		   return info;
		}
		return null;
	}
	@Override
	public Accounts getAccout(long tAccountNo) 
	{
		return accountRepo.findById(tAccountNo).orElse(null);
	}
	@Override
	public TransactionInfo transferFund(Accounts rAccount, long accountNo,double money) 
	{
		Accounts account=accountRepo.findById(accountNo).orElse(null);
		if(account.getAmount()<money)return null;
		rAccount.setAmount(rAccount.getAmount()+money);
		account.setAmount(account.getAmount()-money);
		accountRepo.save(account);
		accountRepo.save(rAccount);
		return trnService.addInfo(rAccount.getAccountNo(),accountNo,money);
		
	}
	
}
