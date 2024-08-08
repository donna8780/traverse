package com.traverse.www.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.traverse.www.vo.AccountsVO;

@Mapper
public interface SignUpDAO {

	@Insert("insert into accounts(userid, userpw, name, nick, email, phone, birth) values(#{userid}, #{userpw}, #{name}, #{nick}, #{email}, #{phone}, #{birth})")
	int insert(AccountsVO input);
	
}
