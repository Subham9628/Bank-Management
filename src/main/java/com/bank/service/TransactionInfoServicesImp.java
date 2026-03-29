package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.DateAndTime;
import com.bank.entity.TransactionInfo;
import com.bank.repository.TransactionInfoRepository;

@Service
public class TransactionInfoServicesImp implements TransactionInfoServices
{

	
	@Autowired
	private TransactionInfoRepository trnRepo;
	
	@Override
	public TransactionInfo addInfo(long accountNo, double money) 
	{
		TransactionInfo info=new TransactionInfo();
		info.setAmount(money);
		info.setDate(new DateAndTime().getDate());
		info.setTime(new DateAndTime().getTime());
		info.setFromAccount(accountNo);
	    info.setToAccount("Self");
     	info.setType("Debit");
     	trnRepo.save(info);
     	return info;
	}
   
}
