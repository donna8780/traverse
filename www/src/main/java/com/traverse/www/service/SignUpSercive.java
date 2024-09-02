package com.traverse.www.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.advice.DuplicateUserException;
import com.traverse.www.component.Sha_512Hash;
import com.traverse.www.model.SignUpDAO;
import com.traverse.www.vo.AccountsVO;

@Service
public class SignUpSercive { // 서비스 클래스: 회원가입 관련 비즈니스 로직을 처리

    @Autowired
    private SignUpDAO dao; // 데이터베이스와의 상호작용을 위한 DAO 클래스 주입

    @Autowired
    private Sha_512Hash hash; // 비밀번호 해시 처리를 위한 해시 클래스 주입

    // 회원가입 처리 메서드
    public int addAccount(AccountsVO input) throws NoSuchAlgorithmException {
        // 중복된 필드를 저장할 리스트
        List<String> duplicateFields = new ArrayList<>();

        // 사용자 ID 중복 검사
        if (checkUserID(input.getUserid()) != null) {
            duplicateFields.add("아이디");
        }

        // 사용자 닉네임 중복 검사
        if (checkUserNick(input.getNick()) != null) {
            duplicateFields.add("닉네임");
        }

        // 전화번호 중복 검사
        if (checkUserPhone(input.getPhone()) != null) {
            duplicateFields.add("전화번호");
        }

        // 이메일 중복 검사
        if (checkEmail(input.getEmail()) != null) {
            duplicateFields.add("이메일");
        }

        // 만약 중복된 필드가 있다면 예외를 발생시킴
        if (!duplicateFields.isEmpty()) {
            throw new DuplicateUserException("중복된 필드가 존재합니다.", duplicateFields);
        }

        // 비밀번호를 해시 처리합니다.
        String userpw = input.getUserpw(); // 원본 비밀번호
        String hashpw = hash.getHash(userpw); // 해시 처리된 비밀번호
        input.setUserpw(hashpw); // 해시 처리된 비밀번호를 객체에 설정

        // 회원 정보를 데이터베이스에 저장
        return dao.insert(input); // insert 메서드를 호출하여 데이터베이스에 회원 정보를 저장
    }

    // 사용자 ID 중복 확인 메서드
    public String checkUserID(String userid) {
        return dao.select(userid); // DAO의 select 메서드를 호출하여 사용자 ID의 존재 여부를 확인
    }

    // 사용자 닉네임 중복 확인 메서드
    public String checkUserNick(String nick) {
        return dao.select_nick(nick); // DAO의 select_nick 메서드를 호출하여 사용자 닉네임의 존재 여부를 확인
    }

    // 사용자 전화번호 중복 확인 메서드
    public String checkUserPhone(String phone) {
        return dao.select_phone(phone); // DAO의 select_phone 메서드를 호출하여 사용자 전화번호의 존재 여부를 확인
    }

    // 사용자 이메일 중복 확인 메서드
    public String checkEmail(String email) {
        return dao.select_email(email); // DAO의 select_email 메서드를 호출하여 사용자 이메일의 존재 여부를 확인
    }
}
