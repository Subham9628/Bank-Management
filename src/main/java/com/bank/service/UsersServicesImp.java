package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Users;
import com.bank.repository.UsersRepository;

@Service
public class UsersServicesImp  implements UsersServices
{
   @Autowired
   private UsersRepository repo;
   
   @Override
   public void save(Users user) 
   {
       repo.save(user);
   }
   
}
