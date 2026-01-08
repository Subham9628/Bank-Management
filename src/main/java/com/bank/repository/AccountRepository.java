package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long>  
{

}
