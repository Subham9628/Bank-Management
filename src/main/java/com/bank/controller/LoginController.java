package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.service.AccountsServices;
import com.bank.service.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController 
{
	@Autowired
	private  AccountsServices accountService; 
	
	@Autowired
	private  UsersServices userService;
   
   @GetMapping("/login-page")
   public String login()
   {
	   return "/user-login/login-form";
   }
   
   @PostMapping("/login-user")
   public String loginUser(String userId , String password,Model model,HttpSession session)
   {
	   boolean isValid=userService.validateUser(userId,password);
	   
	   if(isValid)
	   {   
		   String userName=userService.getUserName(userId);
		   long accountNo=accountService.getAccountNo(userId);
		   session.setAttribute("userName",userName);
		   session.setAttribute("accountNo",accountNo);
		   session.setAttribute("userId", userId);
		   return "home/home"; 
	   }
	   model.addAttribute("msg", "UserId and password is incorrect");
	   model.addAttribute("userId",userId);
	   return "user-login/login-form";
   }
}
