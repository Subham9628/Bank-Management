package com.bank.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bank.entity.Accounts;
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
	  if(money<100)
	  {
		  model.addAttribute("msg", "Deposite minimum 100 Rs ");
		  return "transaction-mng/deposite";
	  }
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
	  if(money<100)
	  {
		  model.addAttribute("msg", "Withdraw minimum 100 Rs ");
		  return "transaction-mng/withdraw";
	  }
	  if(money>100000)
	  {
		  model.addAttribute("msg", "Withdraw maximum 1Lakh Rs ");
		  return "transaction-mng/withdraw";
	  }
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
	  Collections.reverse(list);
	  model.addAttribute("trnInfo",list);
	  return "transaction-mng/miniStatements";
  }
  @GetMapping("/transfer")
  public String transferPage()
  {
	  return "transaction-mng/fundTransfer";
  }
  @PostMapping("/transfer-success")
  public String trnasfer(long rAccountNo, @SessionAttribute long accountNo,double money,Model model)
  {
	  model.addAttribute("accountNo",rAccountNo);
	  model.addAttribute("money", money);
	  if(rAccountNo==accountNo)
	  {
		  model.addAttribute("msg","You can not transfer money own account");
		  return "transaction-mng/fundTransfer";
	  }
	  Accounts account=accountService.getAccout(rAccountNo);
	  if(account==null)
	  {
		  model.addAttribute("msg","Recipient account not found");
		  
		  return "transaction-mng/fundTransfer";
	  }
	  if(money<100)
	  {
		  model.addAttribute("msg1","Transfer amount must be at least 100 Rs");
		  return "transaction-mng/fundTransfer";
	  }
	  TransactionInfo trnInfo=accountService.transferFund(account,accountNo,money);
	  if(trnInfo!=null)
	  {
		  model.addAttribute("info",trnInfo);
		  return "transaction-mng/transferSuccess";
	  }
	  else
	  {
		  model.addAttribute("msg1", "Insufficient funds");
		  return "transaction-mng/fundTransfer";
	  }
  }
  
}
