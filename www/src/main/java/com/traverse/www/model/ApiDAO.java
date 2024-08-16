package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.traverse.www.vo.ApiVO;

@Mapper
public interface ApiDAO {
	
	 @Insert("insert into "
	 		+ "gangwon(title, addr1, mapx, mapy,area_code,cat0,cat1,cat2,cat3,firstimage,firstimage2,sigungucode,tel) "
	 		+ "values(#{title}, #{addr1}, #{mapx}, #{mapy},#{area_code},#{cat0},#{cat1},#{cat2},#{cat3},#{firstimage},#{firstimage2},#{sigungucode},#{tel})")
   void insertSingleData(ApiVO data);

   default void insertData(List<ApiVO> dataList) {
       for (ApiVO data : dataList) {
           insertSingleData(data);
       }
   }
	
}
