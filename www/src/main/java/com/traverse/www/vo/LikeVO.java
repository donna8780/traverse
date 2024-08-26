package com.traverse.www.vo;
/*
like_idx			int
a_idx					int
firstimage		varchar(100)
title					varchar(100)
addr1					varchar(100)
mapx					double
mapy					double
nick					varchar(30)

 */


public class LikeVO {
  
private int like_idx, a_idx;
private String firstimage, title, addr1, nick;
private double mapx, mapy;
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
public String getFirstimage() {
	return firstimage;
}
public void setFirstimage(String firstimage) {
	this.firstimage = firstimage;
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
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
public double getMapx() {
	return mapx;
}
public void setMapx(double mapx) {
	this.mapx = mapx;
}
public double getMapy() {
	return mapy;
}
public void setMapy(double mapy) {
	this.mapy = mapy;
}



	
	
}
