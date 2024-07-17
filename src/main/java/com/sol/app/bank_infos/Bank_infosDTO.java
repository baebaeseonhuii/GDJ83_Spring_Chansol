package com.sol.app.bank_infos;

import java.sql.Date;

public class Bank_infosDTO {
	private String bank_id;
	private Date timepoint;
	private Long balance;
	private Long difference;
	private String account_u;
	
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public Date getTimepoint() {
		return timepoint;
	}
	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Long getDifference() {
		return difference;
	}
	public void setDifference(Long difference) {
		this.difference = difference;
	}
	public String getAccount_u() {
		return account_u;
	}
	public void setAccount_u(String account_u) {
		this.account_u = account_u;
	}
}
