package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.AccountsVO;

@Mapper
public interface AccountsDAO {

	@Select("select * from accounts")
	List<AccountsVO> test();

}
  