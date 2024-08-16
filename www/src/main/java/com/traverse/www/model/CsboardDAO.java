package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.CustomerVO;

@Mapper
public interface CsboardDAO {

	@Select("select * from cus_view")
	List<CustomerVO> cstest();

	@Insert("insert into customer_board(accounts_idx, title, content) values(#{accounts_idx}, #{title}, #{content})")
	int insert(CustomerVO input);
	
	

}
