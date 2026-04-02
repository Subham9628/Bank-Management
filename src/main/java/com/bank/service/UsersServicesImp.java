package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	private  BCryptPasswordEncoder passwordEncoder=new  BCryptPasswordEncoder(); 
   public Accounts save(Users user) 
   {
	   user.setPassword(passwordEncoder.encode(user.getPassword()));
       Users users=userRepo.save(user);
       return accountService.save(users);
       
   }
   @Override
   public boolean validateUser(String userId, String password) 
   {
	     Users user= userRepo.findById(userId).orElse(null);
	     if(user==null)
	     {
	    	   return false;
	     }
	     System.out.println(passwordEncoder.matches(password,user.getPassword()));
	     return passwordEncoder.matches(password,user.getPassword());
	     
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
