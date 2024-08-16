package com.traverse.www.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.traverse.www.vo.ReplyVO;

@Mapper
public interface ReplyDAO {

	@Insert("insert into Reply(contents) values(#{contents})")
	int insert(ReplyVO input);
	
	

}
