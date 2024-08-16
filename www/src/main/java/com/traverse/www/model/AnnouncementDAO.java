package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.AnnouncementVO;



@Mapper
public interface AnnouncementDAO {

	@Select("select * from ann_view")
	List<AnnouncementVO> test();
	
	@Insert("insert into announcement(title, contents, a_idx) values(#{title}, #{contents}, #{a_idx})")
	int insert(AnnouncementVO input);

	@Select("select * from ann_view where announcement_idx = ${announcement_idx}")
	AnnouncementVO selectOne(int idx);

}
