package com.bank.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.TransactionInfo;

public interface TransactionInfoRepository extends JpaRepository<TransactionInfo,Long > {

	List<TransactionInfo> findAllByFromAccount(long accountNo);

	

}
