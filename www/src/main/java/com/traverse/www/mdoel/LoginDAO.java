package com.traverse.www.mdoel;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.traverse.www.vo.AccountsVO;

@Repository
@Mapper
public interface LoginDAO {
	
	@Select("select * from accounts where userid=#{userid} and userpw=#{userpw}")
	AccountsVO selectOne(AccountsVO input);
	
	@Select("select * from accounts where name=#{name} and emaill=#{emaill}")
	AccountsVO findID(AccountsVO input);

}
