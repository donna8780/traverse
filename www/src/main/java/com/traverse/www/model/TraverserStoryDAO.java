package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
