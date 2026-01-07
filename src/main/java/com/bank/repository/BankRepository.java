package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Users;

public interface BankRepository extends JpaRepository<Users, String>
{

}
