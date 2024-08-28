package com.traverse.www.vo;
/*
'idx', 'int', 
'a_idx', 'int', 
'imge1', 'text',
'imge2', 'text', 
'imge3', 'text', 
'imge4', 'text', 
'imge5', 'text', 
'imge6', 'text', 
'imge7', 'text', 
'imge8', 'text', 
'imge9', 'text', 
'imge10', 'text', '
'regin', 'varchar(50)', 
'seldate', 'varchar(50)', 
'w_date', 'datetime', 
'v_count', 'int', 
'title', 'varchar(50)', 
'contents', 'text', 


 */

import java.sql.Date;



public class TraverserStoryVO {
	private String imge1, imge2, imge3, imge4, imge5, imge6, imge7, imge8, imge9 ,imge10;
	private String regin, seldate, title, contents, enddate, nick;
	private int idx, a_idx, v_count;
	private Date w_date;
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	

	public String getImge1() {
		return imge1;
	}
	public void setImge1(String imge1) {
		this.imge1 = imge1;
	}
	public String getImge2() {
		return imge2;
	}
	public void setImge2(String imge2) {
		this.imge2 = imge2;
	}
	public String getImge3() {
		return imge3;
	}
	public void setImge3(String imge3) {
		this.imge3 = imge3;
	}
	public String getImge4() {
		return imge4;
	}
	public void setImge4(String imge4) {
		this.imge4 = imge4;
	}
	public String getImge5() {
		return imge5;
	}
	public void setImge5(String imge5) {
		this.imge5 = imge5;
	}
	public String getImge6() {
		return imge6;
	}
	public void setImge6(String imge6) {
		this.imge6 = imge6;
	}
	public String getImge7() {
		return imge7;
	}
	public void setImge7(String imge7) {
		this.imge7 = imge7;
	}
	public String getImge8() {
		return imge8;
	}
	public void setImge8(String imge8) {
		this.imge8 = imge8;
	}
	public String getImge9() {
		return imge9;
	}
	public void setImge9(String imge9) {
		this.imge9 = imge9;
	}
	public String getImge10() {
		return imge10;
	}
	public void setImge10(String imge10) {
		this.imge10 = imge10;
	}
	public String getRegin() {
		return regin;
	}
	public void setRegin(String regin) {
		this.regin = regin;
	}
	public String getSeldate() {
		return seldate;
	}
	public void setSeldate(String seldate) {
		this.seldate = seldate;
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
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}


	
	
}
