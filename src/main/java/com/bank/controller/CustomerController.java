package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bank.entity.Users;
import com.bank.service.AccountsServices;
import com.bank.service.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController 
{
	 @Autowired
	 private UsersServices userService;
	 @Autowired
	 private AccountsServices accountService;
	 @GetMapping("/logout")
	 public String logout(HttpSession session)
	 {
		 session.invalidate();
		 return "user-login/login-form";
	 }
   @GetMapping("/view-details")
   public String view(@SessionAttribute String userId,@SessionAttribute long accountNo,Model model)
   {
	  Users user=userService.getDetails(userId);
	  model.addAttribute("view", user);
	  double balance=accountService.fetchBalance(accountNo);
	  model.addAttribute("balance",balance);
	  return "customer-mng/viewDetails";
	  
   }
}
