package com.traverse.www.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.AccountsVO;

@Mapper
public interface SignUpDAO {

	@Insert("insert into accounts(userid, userpw, name, nick, email, phone, birth) values(#{userid}, #{userpw}, #{name}, #{nick}, #{email}, #{phone}, #{birth})")
	int insert(AccountsVO input);

	@Select("select userid from accounts where userid = #{userid}")
	String select(String userid);
	
}
