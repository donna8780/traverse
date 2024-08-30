package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.vo.TraverserStoryVO;



@Mapper
public interface TraverserStoryDAO {

  @Insert("INSERT INTO Travelreviews (title, contents, regin, seldate, enddate, a_idx, imge1, imge2, imge3, imge4, imge5, imge6, imge7, imge8, imge9, imge10) " +
      "VALUES (#{title}, #{contents}, #{regin}, #{seldate}, #{enddate}, #{a_idx}, #{imge1}, #{imge2}, #{imge3}, #{imge4}, #{imge5}, #{imge6}, #{imge7}, #{imge8}, #{imge9}, #{imge10})")
int insert(TraverserStoryVO input);
  
  //게시글 4개로 제한하는 구문
  @Select("SELECT * FROM story_view")
  List<TraverserStoryVO> selectAllStories();
  
  @Select("SELECT * FROM story_view WHERE idx = #{idx}")
  TraverserStoryVO selectStoryById(int idx);

  @Select("SELECT * FROM story_view where regin like #{search} or title like #{search}")
  List<TraverserStoryVO> selectSearch(String search);

  @Update("UPDATE Travelreviews SET title = #{title}, contents = #{contents}, regin = #{regin}, seldate = #{seldate}, enddate = #{enddate}, " +
		      "imge1 = #{imge1}, imge2 = #{imge2}, imge3 = #{imge3}, imge4 = #{imge4}, imge5 = #{imge5}, imge6 = #{imge6}, imge7 = #{imge7}, imge8 = #{imge8}, imge9 = #{imge9}, imge10 = #{imge10} " +
		      "WHERE idx = #{idx}")
  int update(TraverserStoryVO story);
		
	@Delete("DELETE FROM Travelreviews WHERE idx = #{idx}")
	int delete(int idx);

	@Update("UPDATE Travelreviews SET v_count = v_count + 1 WHERE idx = #{idx}")
	int incrementViewCount(int idx);

	@Select("select * from story_view order by rand() limit 4")
	List<TraverserStoryVO> getRand();
}
