package com.traverse.www.vo;
/*
idx	int
area_code	int
cat0	varchar(30)
cat1	varchar(30)
cat2	varchar(30)
cat3	varchar(30)
firstimage	text
firstimage2	text
sigungucode	int
tel	varchar(30)
title	text
addr1	text
mapx	double
mapy	double
 */
public class DetailVO {

	private int idx, area_code, sigungucode;
	private String cat0, cat1, cat2, cat3, tel;
	private String firstimage, firstimage2;
	private String title, addr1;
	private Double mapx, mapy;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	public int getSigungucode() {
		return sigungucode;
	}
	public void setSigungucode(int sigungucode) {
		this.sigungucode = sigungucode;
	}
	public String getCat0() {
		return cat0;
	}
	public void setCat0(String cat0) {
		this.cat0 = cat0;
	}
	public String getCat1() {
		return cat1;
	}
	public void setCat1(String cat1) {
		this.cat1 = cat1;
	}
	public String getCat2() {
		return cat2;
	}
	public void setCat2(String cat2) {
		this.cat2 = cat2;
	}
	public String getCat3() {
		return cat3;
	}
	public void setCat3(String cat3) {
		this.cat3 = cat3;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFirstimage2() {
		return firstimage2;
	}
	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public Double getMapx() {
		return mapx;
	}
	public void setMapx(Double mapx) {
		this.mapx = mapx;
	}
	public Double getMapy() {
		return mapy;
	}
	public void setMapy(Double mapy) {
		this.mapy = mapy;
	}
	public String getFirstimage() {
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	
	
}
