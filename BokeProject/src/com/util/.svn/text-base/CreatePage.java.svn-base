package com.util;

public class CreatePage {
	private int currentPage=1;//当前页
	private int totalPage;//总页
	
	private int totalRecord;//总记录
	private int perRecord=5;//一页多少条记录
	
	public CreatePage(){
	}
	
	public CreatePage(int currentPage, int totalPage, int totalRecord,
			int perRecord) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.totalRecord = totalRecord;
		this.perRecord = perRecord;
	}
	
	public int getCurrentPage() {
		return this.currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return this.totalPage;
	}
	public void setTotalPage(int totalRecord,int perRecord) {
		totalPage=(totalRecord/perRecord==0)?(totalRecord/perRecord):(totalRecord/perRecord+1);
	}
	public int getTotalRecord() {
		return this.totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPerRecord() {
		return this.perRecord;
	}
	public void setPerRecord(int perRecord) {
		this.perRecord = perRecord;
	}
	
    
}
