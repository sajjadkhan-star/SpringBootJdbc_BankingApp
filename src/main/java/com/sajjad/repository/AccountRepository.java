package com.sajjad.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sajjad.model.Account;

@Repository
public class AccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

 
	//insert 
	public int insert(Account account) {
		String sql = "insert into account (name , balance) values (?,?)";
		return jdbcTemplate.update(sql, account.getName(), account.getBalance());
	}

	//update
	public int update (Account account) {
		String sql = "update account set name = ?, balance = ? where id = ?";
		return jdbcTemplate.update(sql, account.getName(), account.getBalance(), account.getId());
	}

	//delete by id
	public int deleteById (int id) {
		String sql = "delete from account where id = ?";
		return jdbcTemplate.update(sql, id);

	}

	//delete all
	public int deleteAll () {
		String sql = "delete from account";
		return jdbcTemplate.update(sql);
	}

	//retrieve by id
	public Account getById(int id) {
		String sql = "select * from account where id = ?";
		return jdbcTemplate.queryForObject(sql , (rs,rowNum) -> new Account(rs.getInt("id"),rs.getString("name"),rs.getDouble("balance")),id);

	}

	//retrieve all
	public List<Account> getAll() {
		String sql = "select * from account ";
		return jdbcTemplate.query(sql , (rs,rowNum) -> new Account(rs.getInt("id"),rs.getString("name"),rs.getDouble("balance")));

	}

	// update balance (deposit and withdraw)
	public int updateBalance(int id, double balance) {
		String sql = "update account set balance = ? where id = ?";
		return jdbcTemplate.update(sql , balance, id);
	}
















}