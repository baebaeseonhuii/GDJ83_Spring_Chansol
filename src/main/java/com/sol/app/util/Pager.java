package com.sol.app.util;

import java.util.Map;

public class Pager {
	private Long page;
	private Long perPage;
	private Long perBlock;
	private String kind;
	private String search;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private Long totalPage;
	private boolean pre;
	private boolean next;

	// 페이징 처리 하는 메서드
	public Pager() {
		this.setPerBlock(5L);
		this.setSearch("");
		this.setPage(1L);
		this.setKind("k1");
		this.setPerPage(10L);
	}

	public void makeRow() throws Exception {
		this.setStartRow((this.getPage() - 1L) * this.getPerPage() + 1L);
		this.setLastRow(this.getStartRow() + this.getPerPage() - 1L);

	}

	public void makeNum(Long totalCount) throws Exception {

		this.setTotalPage(totalCount / this.getPerPage());
		if (totalCount % this.getPerPage() != 0L) {
			this.setTotalPage(totalCount / this.getPerPage() + 1L);
		}

		if (this.getPage() > this.getTotalPage()) this.setPage(this.getTotalPage());

		Long totalBlock = (this.getTotalPage() / this.getPerBlock());
		if (this.getTotalPage() * this.getPerBlock() != 0L) {
			totalBlock = (this.getTotalPage() / this.getPerBlock() + 1L);
		}

		Long curBlock = (this.getPage() / this.getPerBlock());
		if (this.getPage() % this.getPerBlock() != 0L) {
			curBlock = (this.getPage() / this.getPerBlock() + 1L);
		}

		if (curBlock > totalBlock) curBlock = totalBlock;
		if (curBlock < 1) curBlock = 1L;

		this.setStartNum((curBlock - 1L) * this.getPerBlock() + 1L);
		this.setLastNum(this.getStartNum() + this.getPerBlock() - 1L);
		if (this.getLastNum() > this.getTotalPage()) this.setLastNum(this.getTotalPage());
		if (this.getStartNum() > this.getLastNum()) this.setStartNum(this.getLastNum() + 1L);

		this.setPre(this.getStartNum() != 1 ? true : false);
		this.setNext(this.getLastNum() != this.getTotalPage() ? true : false);

	}

	public Long getPage() {
		if (this.page == null || this.page < 1) this.page = 1L;
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if (this.search == null) this.search = "";
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}
