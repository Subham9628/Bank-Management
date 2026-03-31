package com.bank.service;

import com.bank.entity.Accounts;
import com.bank.entity.TransactionInfo;
import com.bank.entity.Users;

public interface AccountsServices 
{

	Accounts save(Users users);

	long getAccountNo(String userId);

   double fetchBalance(long accountNo);

   TransactionInfo successDep(long accountNo, double money);

   TransactionInfo successWithdraw(long accountNo, double money);

   


}
