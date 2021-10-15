package com.revature.repository;

import java.util.List;

import com.revature.models.Account;

public interface ManagerRepository {
	
	public List<Account> findApprovalList();
	public boolean approve(String account,boolean b);
	public boolean cancel(String account);
	public int getCashByAccount(String account);
	public void update(String account, int balance);
	
}
