package com.traverse.www.vo;

/*
   idx   int
   areacode   int
   contenttypeid   int
   contentid   int
   firstimage   text
   firstimage2   text
   sigungucode   int
   tel   text
   title   text
   addr1   text
   mapx   double
   mapy   double
*/

public class ApiVO {
   private int idx, areacode, sigungucode, contenttypeid, contentid;
   private String title, addr1, firstimage, firstimage2, tel;
   private double mapx, mapy;
   
   public int getIdx() {
      return idx;
   }
   public void setIdx(int idx) {
      this.idx = idx;
   }
   public int getAreacode() {
      return areacode;
   }
   public void setAreacode(int areacode) {
      this.areacode = areacode;
   }
   public int getSigungucode() {
      return sigungucode;
   }
   public void setSigungucode(int sigungucode) {
      this.sigungucode = sigungucode;
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
   public int getContenttypeid() {
      return contenttypeid;
   }
   public void setContenttypeid(int contenttypeid) {
      this.contenttypeid = contenttypeid;
   }
   public String getFirstimage() {
      return firstimage;
   }
   public void setFirstimage(String firstimage) {
      this.firstimage = firstimage;
   }
   public String getFirstimage2() {
      return firstimage2;
   }
   public void setFirstimage2(String firstimage2) {
      this.firstimage2 = firstimage2;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
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
   public int getContentid() {
      return contentid;
   }
   public void setContentid(int contentid) {
      this.contentid = contentid;
   }
}
