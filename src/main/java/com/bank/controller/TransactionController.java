package com.bank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bank.entity.TransactionInfo;
import com.bank.service.AccountsServices;
import com.bank.service.TransactionInfoServices;
@Controller
public class TransactionController 
{
	@Autowired
	private AccountsServices accountService;
	
	@Autowired
	private TransactionInfoServices trnService;
  @GetMapping("/balance")
  public String getBalance( @SessionAttribute long accountNo , Model model )
  {
		double balance=accountService.fetchBalance(accountNo);
		model.addAttribute("amount", balance);
		return "transaction-mng/balanceenquiry";
  }
  @GetMapping("/deposite-money")
  public String deposite()
  {
	 return "transaction-mng/deposite";
  }
 
  @PostMapping("/success-deposite")
  public String successDeposite(@SessionAttribute long accountNo, double money,Model model)
  {
	  TransactionInfo  info=accountService.successDep(accountNo,money);
	  model.addAttribute("money",money);
	  model.addAttribute("info",info);
	  return "transaction-mng/successDeposite";
  }
  @GetMapping("/withdraw")
  public String withdraw()
  {
	   return "transaction-mng/withdraw";
  }
  @PostMapping("/success-withdraw")
  public String successWithdraw(@SessionAttribute long accountNo, double money,Model model)
  {
	  System.out.println("subham");
	  TransactionInfo  info=accountService.successWithdraw(accountNo,money);
	  if(info!=null)
	  {
		  model.addAttribute("info",info);
		  return "transaction-mng/successWithdraw";
	  }
	  model.addAttribute("msg","Insufficient funnds");
	  return "transaction-mng/withdraw";
  }
  @GetMapping("/statement")
  public String statement(@SessionAttribute long accountNo ,Model model)
  {
	  List<TransactionInfo> list=trnService.getList(accountNo);
	  
	  model.addAttribute("trnInfo",list);
	  return "transaction-mng/miniStatements";
  }
  
}
