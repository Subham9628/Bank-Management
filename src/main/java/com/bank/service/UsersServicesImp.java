package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Accounts;
import com.bank.entity.Users;
import com.bank.repository.UsersRepository;

@Service
public class UsersServicesImp  implements UsersServices
{
	@Autowired
   private UsersRepository userRepo;
	@Autowired
   private AccountsServices accountService;
   @Override
   public Accounts save(Users user) 
   {
       Users users=userRepo.save(user);
       return accountService.save(users);
       
   }
   public boolean validateUser(String userId, String password) 
   {
	   return userRepo.existsByUserIdAndPassword(userId,password);
   }
   @Override
   public String getUserName(String userId) 
   {
	  Users user=userRepo.findById(userId).orElse(null);
	  return user.getFullName();
   }
   @Override
   public Users getDetails(String userId) 
   {
	 return userRepo.findById(userId).orElse(null);
   }
   
   
}
