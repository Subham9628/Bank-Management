package com.bank.service;

import com.bank.entity.TransactionInfo;

public interface TransactionInfoServices{

	TransactionInfo addInfo(long accountNo, double money);

}
