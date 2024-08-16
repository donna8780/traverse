package com.traverse.www.vo;

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

public class MapAPIVO {
	private int like_idx, a_idx, p_idx;
	private String place_name, place_add, place_img;
	private double place_x, place_y;
	
	public int getLike_idx() {
		return like_idx;
	}
	public void setLike_idx(int like_idx) {
		this.like_idx = like_idx;
	}
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_add() {
		return place_add;
	}
	public void setPlace_add(String place_add) {
		this.place_add = place_add;
	}
	public String getPlace_img() {
		return place_img;
	}
	public void setPlace_img(String place_img) {
		this.place_img = place_img;
	}
	public double getPlace_x() {
		return place_x;
	}
	public void setPlace_x(double place_x) {
		this.place_x = place_x;
	}
	public double getPlace_y() {
		return place_y;
	}
	public void setPlace_y(double place_y) {
		this.place_y = place_y;
	}
}
