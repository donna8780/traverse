package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.component.Paging;
import com.traverse.www.vo.AnnouncementVO;



@Mapper
public interface AnnouncementDAO {

	@Select("select * from ann_view LIMIT #{perBoard} OFFSET #{offset}")
	List<AnnouncementVO> announce(Paging pg);
	
	@Insert("insert into announcement(title, contents, a_idx) values(#{title}, #{contents}, #{a_idx})")
	int insert(AnnouncementVO input);

	@Select("select * from ann_view where announcement_idx = ${announcement_idx}")
	AnnouncementVO selectOne(int idx);

	@Delete("delete from announcement where announcement_idx = ${announcement_idx}")
	int delete(AnnouncementVO idx);

	@Update("update announcement "
						+ "set "
							+ "title = #{title}, "
							+ "contents = #{contents} "
						+ "where announcement_idx = #{announcement_idx}")
	int update(AnnouncementVO input);
	
	@Select("select count(*) from announcement")
	int totalBoard();

}
