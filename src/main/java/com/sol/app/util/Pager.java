package com.sol.app.util;

public class Pager {
	private Long startRow;
	private Long lastRow;
	private Long page;
	private Long totalCount;
	private Long perPage;
	private Long totalPage;
	private Long perBlock;
	private long startNum;
	private long lastNum;
	private long totalBlock;
	private long curBlock;
	
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
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public long getStartNum() {
		return startNum;
	}
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}
	public long getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(long totalBlock) {
		this.totalBlock = totalBlock;
	}
	public long getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(long curBlock) {
		this.curBlock = curBlock;
	}
}
