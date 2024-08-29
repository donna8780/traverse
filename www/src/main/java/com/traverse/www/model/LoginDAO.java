package com.traverse.www.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.traverse.www.vo.AccountsVO;

@Repository
@Mapper
public interface LoginDAO {
	
	@Select("select * from accounts where userid=#{userid} and userpw=#{userpw}")
	AccountsVO selectOne(AccountsVO input);
	
	@Select("select userid from accounts where name=#{name} and email=#{email}")
	String findID(AccountsVO input);
	
	@Select("select * from accounts where userid=#{userid} and name=#{name} and email=#{email}")
	AccountsVO findPW(AccountsVO input);
	
	@Update("update accounts set userpw=#{userpw} where accounts_idx=#{accounts_idx}")
	int updatenewPW(AccountsVO input);

}
