package com.traverse.www.vo;

/*
	board_idx	int
	title	varchar(255)
	content	text
	create_at	timestamp
	accounts_idx	int
	
	nick	varchar(30)
 */

import com.google.protobuf.Timestamp;

public class CustomerVO {

	private int board_idx, accounts_idx;
	private String title, content,nick;
	private Timestamp create_at;
	
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getAccounts_idx() {
		return accounts_idx;
	}
	public void setAccounts_idx(int accounts_idx) {
		this.accounts_idx = accounts_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Timestamp getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}
}
