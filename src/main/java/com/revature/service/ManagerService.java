package com.revature.service;

import java.util.List;

import com.revature.models.Account;
import com.revature.repository.ManagerRepository;
import com.revature.repository.ManagerRepositoryImpl;

public class ManagerService {

	private ManagerRepository managerRepository = new ManagerRepositoryImpl();

	public boolean cancelAccount(String account) {
		return managerRepository.cancel(account);
		
	}

	public int[] transfer(String account1, String account2, String amount) {
		int balance1 = managerRepository.getCashByAccount(account1);
		balance1 = balance1 - Integer.parseInt(amount);
		managerRepository.update(account1,balance1);
		int balance2 = managerRepository.getCashByAccount(account2);
		balance2 = balance2 + Integer.parseInt(amount);
		managerRepository.update(account2,balance2);
		int[] balances = {balance1,balance2};
		return balances;
		
	}

	public int deposit(String account, String amount) {
		int balance = managerRepository.getCashByAccount(account);
		balance = balance + Integer.parseInt(amount);
		managerRepository.update(account,balance);
		return balance;
		
	}

	public int withdraw(String account, String amount) {
		int balance = managerRepository.getCashByAccount(account);
		balance = balance - Integer.parseInt(amount);
		managerRepository.update(account,balance);
		return balance;
		
	}

	public List<Account> getApprovalList() {
		return managerRepository.findApprovalList();
		
	}

	public boolean approve(String account, String approval) {
		if(approval.equals("Approve")) {
			managerRepository.approve(account,true);
			return true;
		}
		else if(approval.equals("Deny")){
			managerRepository.cancel(account);
			return true;
		}
		return false;
	}

	public Account createAccount(String username) {
		return managerRepository.createAccount(username);
		
	}

	public List<Account> seeAccounts(String username) {
		return managerRepository.seeAccountsByUsername(username);
		
	}


}
