package com.bank.service;


import java.util.List;

import com.bank.entity.TransactionInfo;

public interface TransactionInfoServices{

	TransactionInfo addInfo(long accountNo, double money,String type);

	List<TransactionInfo> getList(long accountNo);

    TransactionInfo addInfo(long rAccountNo, long tAccountNo, double money);

	

}
