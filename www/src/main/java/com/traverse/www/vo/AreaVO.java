package com.traverse.www.vo;

//VO 클래스
public class AreaVO {
 private String code;
 private String name;

 public AreaVO(String code, String name) {
     this.code = code;
     this.name = name;
 }

 public String getCode() {
     return code;
 }

 public void setCode(String code) {
     this.code = code;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }
}

