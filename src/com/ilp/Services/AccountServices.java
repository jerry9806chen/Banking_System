package com.ilp.Services;

import java.util.ArrayList;

import com.ilp.DAO.AccountDao;
import com.ilp.DTO.Account;

public class AccountServices {

	public boolean createAccount(Account account) {
		AccountDao accountDao = new AccountDao();
		boolean created = accountDao.createAccount(account);
		return created;
	}

	public ArrayList<Account> viewCustomerAccounts(int customerID) {

		AccountDao accountDao = new AccountDao();
		ArrayList<Account> accountList = accountDao.viewCustomerAccounts(customerID);
		return accountList;
	}
	
	public Account viewCustomerAccountByAcctId(int accountID) {
		AccountDao accountDao = new AccountDao();
		Account account = accountDao.viewCustomerAccountByAcctId(accountID);
		return account;
	}

	public boolean deleteAccount(int customerID) {
		AccountDao accountDao = new AccountDao();
		return accountDao.deleteAccount(customerID);
	}

	public boolean makeDeposit(int accountId, int amount) {
		AccountDao accountDao = new AccountDao();
		return accountDao.makeDeposit(accountId, amount);
	}

	public boolean makeWithdrawal(int accountId, int amount) {
		AccountDao accountDao = new AccountDao();
		return accountDao.makeWithdrawal(accountId, amount);
	}

	public ArrayList<Account> viewAccountStatus() {
		AccountDao accountDao = new AccountDao();
		ArrayList<Account> accountStatusList = accountDao.viewAccountStatus();
		return accountStatusList;
	}
}