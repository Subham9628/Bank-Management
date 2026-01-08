package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.entity.Accounts;
import com.bank.entity.Users;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountsServices;
import com.bank.service.UsersServices;

@Controller
public class BankController 
{
	@Autowired
    private UsersServices usersService;
	@Autowired
	private AccountsServices accountServcies;
	@Autowired
	//private AccountRepository accountRepo;

   
   @GetMapping("/registration")
   public String registrationForm()
   {
	   return "user-login/registration";
   }
   @PostMapping("/registration-success")
   public String success(@ModelAttribute Users user,Model model)
   {
	   usersService.save(user);
	 
       Accounts account=new Accounts();
       String userId=user.getUserId();
       account.setAmount(0);
       account.setUserId(userId);
	   Accounts accountsave=accountServcies.save(account);
	   System.out.println(accountsave.getAccountNo());
	   model.addAttribute("AccountNo",accountsave.getAccountNo());
	   return "user-login/registration-success";
   }
   
}
