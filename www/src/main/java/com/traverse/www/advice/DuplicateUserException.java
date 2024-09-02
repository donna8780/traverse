package com.traverse.www.advice;

import java.util.List;

//중복된 사용자 정보가 존재 시 발생시키는 예외를 정의
//런타임동안 발생할 수 있는 예외 클래스를 상속받음
public class DuplicateUserException extends RuntimeException{

	//어떤 중복된 필드가 있는지 저장하는 역할
	private List<String> fieldNames;
	
	
	public DuplicateUserException(String message, List<String> fieldNames) {
		//부모 클래스인 런타임 익셉션의 생성자로 메세지를 전달=>메세지는 예외 발생시 오류 메세지로 사용
		super(message);
		this.fieldNames = fieldNames;
		
	}
	//field값들(중복된 값이 하나가 아닐 수도 있음에)을 가져오는 getter 메서드, 예외 발생 시 중복된 이름 반환
	   public List<String> getFieldNames() {
	        return fieldNames;
	    }
}
