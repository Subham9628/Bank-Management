package com.bank.service;

import com.bank.entity.Accounts;
import com.bank.entity.TransactionInfo;

public interface AccountsServices 
{

	Accounts save(Accounts account);

	long getAccountNo(String userId);

   double fetchBalance(long accountNo);

   TransactionInfo successDep(long accountNo, double money);

   TransactionInfo successWithdraw(long accountNo, double money);


}
