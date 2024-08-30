package com.traverse.www.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.vo.AccountsVO;



@Mapper
public interface MyPageDAO {

   @Update("update accounts "
               + "set "
                  + "userpw = #{userpw}, "
                  + "nick = #{nick}, "
                  + "email = #{email} "
               + "where accounts_idx = #{accounts_idx}")
   int update(AccountsVO input);

   @Delete("delete from accounts where accounts_idx = #{idx}")
	 int delete(int idx);
   
   @Update("update accounts "
       + "set profile = #{profile} "
       + "where accounts_idx = #{accounts_idx}")
   int updateProfile(AccountsVO user);

}
