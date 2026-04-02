package com.bank.service;

import java.util.List;

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
	public TransactionInfo addInfo(long accountNo, double money,String type) 
	{
		TransactionInfo info=new TransactionInfo();
		info.setAmount(money);
		info.setDate(new DateAndTime().getDate());
		info.setTime(new DateAndTime().getTime());
		info.setFromAccount(accountNo);
	    info.setToAccount("Self");
     	info.setType(type);
     	trnRepo.save(info);
     	return info;
	}

	@Override
	public List<TransactionInfo> getList(long accountNo) 
	{
		return trnRepo.findAllByFromAccount(accountNo);
	}

	@Override
	public TransactionInfo addInfo(long rAccountNo, long tAccountNo, double money)
    {
		String date=new DateAndTime().getDate();
		String time=new DateAndTime().getTime();
		TransactionInfo info1=new TransactionInfo();
		info1.setAmount(money);
		info1.setDate(date);
		info1.setTime(time);
		info1.setFromAccount(tAccountNo);
	    info1.setToAccount(rAccountNo+"");
     	info1.setType("Debit");
     	trnRepo.save(info1);
		TransactionInfo info2=new TransactionInfo();
		info2.setAmount(money);
		info2.setDate(date);
		info2.setTime(time);
		info2.setFromAccount(tAccountNo);
	    info2.setToAccount(rAccountNo+"");
     	info2.setType("Credit");
     	trnRepo.save(info2);
		return info1;
	}
}
