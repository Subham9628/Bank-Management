package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Users;
import com.bank.repository.BankRepository;

@Service
public class BankServicesImp  implements BankServices
{
   @Autowired
   private BankRepository repo;
   
   @Override
   public void save(Users user) 
   {
       repo.save(user);
   }
   
}
