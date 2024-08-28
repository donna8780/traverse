package com.traverse.www.vo;
/*
'rep_idx', 'int',
'a_idx', 'int',
'c_idx', 'int',
'contents', 'varchar(255)',
'w_date', 'datetime', 'YES',
'nick', 'varchar(30)', 'NO',

 */

import java.sql.Date;

public class ReplyVO {
	private int rep_idx, a_idx, c_idx;
	private String contents, nick;
	private Date w_date;
	public int getRep_idx() {
		return rep_idx;
	}
	public void setRep_idx(int rep_idx) {
		this.rep_idx = rep_idx;
	}
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	
	

}