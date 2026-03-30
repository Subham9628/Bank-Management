package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.entity.Accounts;
import com.bank.entity.Users;
import com.bank.service.UsersServices;

@Controller
public class RegistrationController 
{
	@Autowired
    private UsersServices usersService;
	@Autowired
	//private AccountRepository accountRepo;
   @GetMapping("/registration")
   public String registrationForm()
   {
	   return "registration/registration";
   }
   @PostMapping("/registration-success")
   public String success(@ModelAttribute Users user,Model model)
   {
	   Accounts account=usersService.save(user);
	   model.addAttribute("AccountNo",account.getAccountNo());
	   return "registration/registration-success";
   }  
}
