package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String>
{

}
