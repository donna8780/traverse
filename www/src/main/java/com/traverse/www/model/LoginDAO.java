package com.traverse.www.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.traverse.www.vo.AccountsVO;

@Repository
@Mapper
public interface LoginDAO {
	
	@Select("select * from accounts where userid=#{userid} and userpw=#{userpw}")
	AccountsVO selectOne(AccountsVO input);
	
	@Select("select * from accounts where name=#{name} and email=#{email}")
	AccountsVO findID(AccountsVO input);

}
