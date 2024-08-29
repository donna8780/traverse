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
  
  // 모든 게시글을 선택하는 메서드 추가
  @Select("SELECT * FROM story_view")
  List<TraverserStoryVO> selectAllStories();
  
  @Select("SELECT * FROM story_view WHERE idx = #{idx}")
  TraverserStoryVO selectStoryById(int idx);
}
