package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bank.service.AccountsServices;
@Controller
public class TransactionController 
{
	@Autowired 
	private AccountsServices accountService;
  @GetMapping("/balance")
  public String getBalance( @SessionAttribute long accountNo , Model model )
  {
		double balance=accountService.fetchBalance(accountNo);
		model.addAttribute("amount", balance);
		return "transaction-mng/balanceenquiry";
  }
}
