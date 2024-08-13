package com.traverse.www.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


public class AnnouncementVO {
	private int accounts_idx, announcement_idx, a_idx, v_count;
	private String title, contents, nick;
	private Date w_date;
	public int getAnnouncement_idx() {
		return announcement_idx;
	}
	public void setAnnouncement_idx(int announcement_idx) {
		this.announcement_idx = announcement_idx;
	}
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}
	public int getV_count() {
		return v_count;
	}
	public void setV_count(int v_count) {
		this.v_count = v_count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	
}
