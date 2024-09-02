package com.traverse.www.advice;


//Exception은 checked예외이기 때문에 예외처리 필수
//발생 가능성이 있는 곳에 반드시 try-catch로 처리하거나 throw로 명시
//컴파일러에서 예외처리를 강제하기 때문에 이 예외를 처리하지 않으면 컴파일 에러가 생김


//사용자 입력값이 유효하지 않을 때, 필수 입력 필드가 비어 있거나 형식이 맞지 않을 때
public class ValidationException extends Exception{
    public ValidationException(String message) {
        super(message);
    }

}
