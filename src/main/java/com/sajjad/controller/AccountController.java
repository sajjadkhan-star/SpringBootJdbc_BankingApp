package com.sajjad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sajjad.model.Account;
import com.sajjad.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController { 

	@Autowired
	private AccountService service;

	@PostMapping("/create")
	public String create (@RequestBody Account account) {
		return service.create(account);
	}

	@PutMapping("/update")
	public String update (@RequestBody Account account) {
		return service.update(account);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id ) {
		return service.deleteById(id);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return service.deleteAll();
	}

	@GetMapping("/{id}")
	public Account getById(@PathVariable int id ) {
		return service.getById(id);
	}

	@GetMapping("/all")
	public List<Account> getAll() {
		return service.getAll();
	}

	@PostMapping("/deposit/{id}/{amount}")
	public String deposit(@PathVariable int id, @PathVariable double amount) {
		return service.deposit(id, amount);
	}

	@PostMapping("/withdraw/{id}/{amount}")
	public String withdraw(@PathVariable int id, @PathVariable double amount) {
		return service.withdraw(id, amount);
	}

}
