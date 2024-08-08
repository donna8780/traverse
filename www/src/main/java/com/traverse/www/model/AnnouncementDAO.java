package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.AnnouncementVO;



@Mapper
public interface AnnouncementDAO {

	@Select("select * from announcement")
	List<AnnouncementVO> test();
	
	@Insert("insert into Announcement(title, a_idx, contents) values(#{title}, #{a_idx}, #{contents})")
	int insert(AnnouncementVO input);

}
