package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.vo.ReplyVO;

@Mapper
public interface ReplyDAO {

	@Insert("insert into reply(c_idx, a_idx, contents) values(#{c_idx}, #{a_idx}, #{contents})")
	int insert(ReplyVO input);

	@Select("select * from reply_view "
					+ "where c_idx = #{c_idx}")
	List<ReplyVO> selectAll(int idx);

	@Delete("delete from reply where rep_idx = ${rep_idx}")
	int delete(int idx);

	@Update("UPDATE reply SET contents = #{contents} where rep_idx = #{rep_idx}")
	int update(ReplyVO input);


}
