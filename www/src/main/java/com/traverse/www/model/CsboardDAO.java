package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.component.Paging;
import com.traverse.www.vo.CustomerVO;

@Mapper
public interface CsboardDAO {

	@Select("select * from cus_view order by board_idx desc LIMIT #{perBoard} OFFSET #{offset}")
	List<CustomerVO> cstest(Paging pg);

	@Insert("insert into customer_board(accounts_idx, title, content) values(#{accounts_idx}, #{title}, #{content})")
	int insert(CustomerVO input);

	@Select("select * from cus_view where board_idx = ${board_idx}")
	CustomerVO selectOne(int idx);

	@Update("update customer_board "
			+ "set "
			+ "title = #{title}, "
			+ "content = #{content} "
		+ "where board_idx = #{board_idx}")
	int update(CustomerVO input);

	@Delete("delete from customer_board where board_idx = ${board_idx}")
	int delete(CustomerVO idx);

	@Select("select count(*) from cus_view")
	int totalQna();
	
	

}
