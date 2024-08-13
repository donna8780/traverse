package com.traverse.www.vo;

import lombok.Getter;
import lombok.Setter;

/*
	like_idx	int
	a_idx	int
	place_name	varchar(30)
	place_add	varchar(150)
	place_x	double
	place_y	double
	place_img	varchar(50)
	p_idx	int
 */

@Getter
@Setter
public class MapAPIVO {
	private int like_idx, a_idx, p_idx;
	private String place_name, place_add, place_img;
	private double place_x, place_y;
}
