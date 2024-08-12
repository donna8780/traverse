package com.traverse.www.CsboardDAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.CustomerVO;

@Mapper
public interface CsboardDAO {

	@Select("select * from cus_view")
	List<CustomerVO> cstest();

}
