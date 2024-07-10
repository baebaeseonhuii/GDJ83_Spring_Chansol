package com.sol.app.accounts;

public class ListOption {

	private String bank_id;
	private Integer order; // 0 desc, 1 asc
	private Integer IO;

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getIO() {
		return IO;
	}

	public void setIO(Integer iO) {
		IO = iO;
	}

}
