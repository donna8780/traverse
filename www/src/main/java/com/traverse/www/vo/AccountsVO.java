package com.traverse.www.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/*
	accounts_idx	int
	userid	varchar(30)
	userpw	varchar(30)
	nick	varchar(30)
	emaill	varchar(30)
	name	varchar(30)
	phone	varchar(30)
	birth	date
	profile1	varchar(30)
 */

@Getter
@Setter
public class AccountsVO {
	private int accounts_idx;
	private String userid, userpw, nick, email, name, phone, profile1;
	private Date birth;
}
