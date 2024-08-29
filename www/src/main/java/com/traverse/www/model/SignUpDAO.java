package com.traverse.www.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.AccountsVO;

@Mapper
public interface SignUpDAO {

	
	@Insert("insert into accounts(userid, userpw, name, nick, email, phone, birth) values(#{userid}, #{userpw}, #{name}, #{nick}, #{email}, #{phone}, #{birth})")
	int insert(AccountsVO input);
	//아이디 중복 체크
	@Select("select userid from accounts where userid = #{userid}")
	String select(String userid);
	//닉네임 중복 체크
	@Select("select nick from accounts where nick = #{userNick}")
	String select_nick(String userNick);
	//전화번호 중복 체크
	@Select("select phone from accounts where phone = #{phone}")
	String select_phone(String phone);
	//이메일 중복 체크
	@Select("select email from accounts where email = #{email}")
	String select_email(String email);
}
