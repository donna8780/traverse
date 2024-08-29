package com.traverse.www.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.traverse.www.advice.DuplicateUserException;
import com.traverse.www.advice.ValidationException;
import com.traverse.www.service.SignUpSercive;
import com.traverse.www.vo.AccountsVO;

// 회원가입 관련 요청을 처리
@Controller
@RequestMapping("/member") // '/member'로 시작하는 URL 요청을 처리
public class SignUpController {
    private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private SignUpSercive ss; // SignUpService를 주입받아 사용

    // 회원가입 페이지를 보여주는 메서드
    @GetMapping("/signUp")
    public String signUp() {
        return "member/signUp"; // 'member/signUp' 뷰를 반환하여 회원가입 페이지로 이동
    }

    // 회원가입 폼 제출을 처리하는 메서드
    @PostMapping("/signUp")
    public String signUp(AccountsVO input, RedirectAttributes redirectAttributes) throws DuplicateUserException {
        try {
            // 입력값에 대한 검증 로직 호출
            validateInput(input);

            // 검증 통과 시 서비스 계층의 회원가입 로직 호출
            ss.addAccount(input);
            return "redirect:/"; // 회원가입 성공 시 메인 페이지로 리다이렉트
        } catch (NoSuchAlgorithmException e) {
            logger.error("Password hashing failed", e); // 올바른 로그 호출
            redirectAttributes.addFlashAttribute("errorMessage", "서버에서 문제가 발생했습니다. 다시 시도해 주세요.");
            return "redirect:/member/signupError"; // 에러 발생 시 에러 페이지로 리다이렉트
        } catch (DuplicateUserException e) {
            logger.warn("Duplicate user information: " + input.toString(), e); // 올바른 로그 호출
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/member/signupError"; // 중복된 정보로 인한 에러 페이지로 리다이렉트
        } catch (ValidationException e) {
            logger.warn("Validation failed for input: " + input.toString(), e); // 올바른 로그 호출
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/member/signUp"; // 검증 실패 시 회원가입 페이지로 다시 리다이렉트
        } catch (Exception e) {
            logger.error("Unexpected error occurred during signup", e); // 올바른 로그 호출
            redirectAttributes.addFlashAttribute("errorMessage", "예기치 않은 오류가 발생했습니다. 다시 시도해 주세요.");
            return "redirect:/member/signupError"; // 일반적인 예외 처리 후 에러 페이지로 리다이렉트
        }
    }

    // 입력이 비어있을 때 수행하는 메서드
    private void validateInput(AccountsVO input) throws ValidationException {
        if (input.getUserid() == null || input.getUserid().isEmpty()) {
            // 아이디가 비어있거나 null인 경우 예외 발생
            throw new ValidationException("아이디를 입력해 주세요.");
        }
        if (input.getUserpw() == null || input.getUserpw().isEmpty()) {
            // 비밀번호가 비어있거나 null인 경우 예외 발생
            throw new ValidationException("비밀번호를 입력해 주세요.");
        }
        if (input.getNick() == null || input.getNick().isEmpty()) {
            // 닉네임이 비어있거나 null인 경우 예외 발생
            throw new ValidationException("닉네임을 입력해 주세요.");
        }
        if (input.getPhone() == null || input.getPhone().isEmpty()) {
            // 전화번호가 비어있거나 null인 경우 예외 발생
            throw new ValidationException("전화번호를 입력해 주세요.");
        }
        if (input.getEmail() == null || input.getEmail().isEmpty()) {
            // 이메일이 비어있거나 null인 경우 예외 발생
            throw new ValidationException("이메일을 입력해 주세요.");
        }
    }

    // 회원가입 실패 시 에러 페이지를 보여주는 메서드
    @GetMapping("/signupError")
    public String signUpError() {
        return "member/signupError"; // 'member/signupError' 뷰를 반환하여 에러 페이지로 이동
    }

    // 아이디 중복 확인을 처리하는 메서드
    @GetMapping("/checkUserid")
    @ResponseBody
    public Map<String, Object> checkUserID(@RequestParam(name = "userid") String userid) {
        Map<String, Object> result = new HashMap<>();
        String check = ss.checkUserID(userid); // 아이디 중복 체크를 서비스에서 수행
        // 아이디 중복 여부에 따라 메시지 설정
        String msg = check == null ? "사용 가능한 아이디 입니다." : check + "는 중복된 아이디 입니다.";
        result.put("name", msg); // 메시지를 맵에 저장
        return result; // 맵을 JSON 형식으로 반환
    }

    // 닉네임 중복 확인을 처리하는 메서드
    @GetMapping("/checkUserNick")
    @ResponseBody
    public Map<String, Object> checkUserNick(@RequestParam(name = "userNick") String userNick) {
        Map<String, Object> result = new HashMap<>();
        String check_nick = ss.checkUserNick(userNick); // 닉네임 중복 체크를 서비스에서 수행
        // 닉네임 중복 여부에 따라 메시지 설정
        String msg = check_nick == null ? "사용 가능한 닉네임입니다." : check_nick + "는 중복된 닉네임 입니다.";
        result.put("nick", msg); // 메시지를 맵에 저장
        return result; // 맵을 JSON 형식으로 반환
    }

    // 전화번호 중복 확인을 처리하는 메서드
    @GetMapping("/checkUserPhone")
    @ResponseBody
    public Map<String, Object> checkUserPhone(@RequestParam(name = "phone") String phone) {
        Map<String, Object> result = new HashMap<>();
        String check_phone = ss.checkUserPhone(phone); // 전화번호 중복 체크를 서비스에서 수행
        // 전화번호 중복 여부에 따라 메시지 설정
        String msg = check_phone == null ? "사용 가능한 전화번호입니다." : check_phone + "는 중복된 전화번호 입니다.";
        result.put("phone", msg); // 메시지를 맵에 저장
        return result; // 맵을 JSON 형식으로 반환
    }

    // 이메일 중복 확인을 처리하는 메서드
    @GetMapping("/checkEmail")
    @ResponseBody
    public Map<String, Object> checkEmail(@RequestParam(name = "email") String email) {
        Map<String, Object> result = new HashMap<>();
        String check_email = ss.checkEmail(email); // 이메일 중복 체크를 서비스에서 수행
        // 이메일 중복 여부에 따라 메시지 설정
        String msg = check_email == null ? "사용 가능한 이메일 입니다." : check_email + "는 중복된 이메일 입니다.";
        result.put("email", msg); // 메시지를 맵에 저장
        return result; // 맵을 JSON 형식으로 반환
    }
}
