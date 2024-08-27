package com.traverse.www.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/*
	accounts_idx	int
	userid	varchar(30)
	userpw	varchar(30)
	nick	varchar(30)
	email	varchar(30)
	name	varchar(30)
	phone	varchar(30)
	birth	date
	profile1	varchar(30)
 */

public class AccountsVO {
	private int accounts_idx;
	private String userid, userpw, nick, email, name, phone, profile1;

	 @DateTimeFormat(pattern = "yyyy.MM.dd")
	    private LocalDate birth;
	
	public int getAccounts_idx() {
		return accounts_idx;
	}
	public void setAccounts_idx(int accounts_idx) {
		this.accounts_idx = accounts_idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfile1() {
		return profile1;
	}
	public void setProfile1(String profile1) {
		this.profile1 = profile1;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
}
