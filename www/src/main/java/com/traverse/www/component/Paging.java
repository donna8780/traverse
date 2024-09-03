package com.traverse.www.component;

public class Paging {
	private int offset, reqPage,perBoard=5;
	private int totalBoard, totalPage;
	private int index=0;
	private int perPage = 10;
	private int begin,end;
	private boolean prev,next;
	
	public Paging(int reqPage, int totalBoard) {
		this.reqPage = reqPage;
		this.totalBoard = totalBoard;
		
		offset = (reqPage - 1) * perBoard;
		
		totalPage = totalBoard / perBoard;
		totalPage = (totalBoard + perBoard - 1) / perBoard;

		index = (reqPage-1) / perPage;
		begin = index * 10 + 1;
		end = (index +1) * perPage;
		
		end = (end < totalPage) ? end : totalPage;
		if(end == 0) {
			end = 1;
		}
		prev = (index != 0);
		next = (end != totalPage);
	}
	
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getReqPage() {
		return reqPage;
	}
	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}
	public int getPerBoard() {
		return perBoard;
	}
	public void setPerBoard(int perBoard) {
		this.perBoard = perBoard;
	}
	public int getTotalBoard() {
		return totalBoard;
	}
	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
}
