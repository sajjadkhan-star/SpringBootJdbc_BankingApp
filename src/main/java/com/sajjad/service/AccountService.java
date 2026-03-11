package com.sajjad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajjad.model.Account;
import com.sajjad.repository.AccountRepository;


@Service
public class AccountService {


	@Autowired
	private AccountRepository repository;

	// create
	public String create (Account account) {
		repository.insert(account);
		return "Account Created Successfully";
	}

	//update
	public String update (Account account) {
		repository.update(account);
		return "Account Updated Successfully";
	}

	//delete by id
	public String deleteById (int id) {
		repository.deleteById(id);
		return "Account Deleted By Id Successfully";
	}

	//delete all
	public String deleteAll () {
		repository.deleteAll();
		return "All The Accounts Deleted Successfully";
	}

	//retrieve by id
	public Account getById(int id) {
		return repository.getById(id);
	}

	//retrieve all
	public List<Account> getAll() {
		return repository.getAll();
	}

	@Transactional
	public String deposit (int id, double amount) {
		Account account = repository.getById(id);
		double newBalance = account.getBalance() + amount;
		repository.updateBalance(id, newBalance);
		return "Deposit successfully : New Balance" + newBalance;
	}

	@Transactional
	public String withdraw (int id, double amount) {
		Account account = repository.getById(id);

		if (account.getBalance() < amount) {
			throw new RuntimeException("Insuffician Balance"); 
		}
		double newBalance = account.getBalance() - amount;
		repository.updateBalance(id, newBalance);
		return "withdraw successfully : New Balance" + newBalance;
	}

}