package com.care.quiz.membership.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.quiz.membership.dao.IMemberDAO;
import com.care.quiz.membership.dto.LoginDTO;
import com.care.quiz.membership.dto.MemberDTO;
import com.care.quiz.membership.dto.PostcodeDTO;

@Service
public class MemberServiceImpl implements IMemberService {
	@Autowired IMemberDAO dao;
	@Autowired HttpSession session;
	
	// 아이디 중복 확인
	@Override
	public String isExistId(String id) {
		if(id == null)
			return "입력 후 확인해주세요.";
		if(dao.isExistId(id) == 0) {
			// 회원가입 시 중복 체크를 했는지 확인하기 위한 session
			session.setAttribute("isExistId", "y");
			return "사용가능한 아이디입니다.";
		}
		// 사용가능한 아이디 체크했다가 중복 아이디로 체크 시 session이 없어야하기 때문에 invalidate
		session.invalidate();
		return "중복 아이디입니다.";
	}
	
	// 회원가입 
	@Override
	public String memberProc(MemberDTO member, PostcodeDTO post) {
		LoginDTO login = member;
		
		// 입력값 체크
		if(login.getId() == null || login.getId().isEmpty())
			return "아이디를 입력하세요.";
		if(login.getPw() == null || login.getPw().isEmpty())
			return "비밀번호를 입력하세요.";
		if(dao.isExistId(login.getId()) > 0)
			return "중복 아이디 입니다.";
		if(login.getPw().equals(login.getPwOk()) == false) {
			return "입력하신 두 비밀번호가 일치하지 않습니다.";
		}
		// 아이디 중복 체크 했는지 확인하는 if문
		if(session.getAttribute("isExistId") == null) {
			return "아이디 중복 확인 해주세요.";
		}
//		// 인증번호 확인하는 if문
//		if(session.getAttribute("check") == null || session.getAttribute("check") == "n") {
//			return "인증번호를 확인해주세요.";
//		}
		
		// 비밀번호 암호화
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String cipherPassword = encoder.encode(login.getPw());
		login.setPw(cipherPassword);
		
		if(dao.insertLogin(login) > 0)
			return "가입 완료";
		else
			return "가입 실패";
	}

	// 로그인
	@Override
	public String loginProc(LoginDTO login) {
		// 입력여부 검증
		if(login.getId() == null || login.getId().isEmpty())
			return "아이디를 입력하세요.";
		if(login.getPw() == null || login.getPw().isEmpty())
			return "비밀번호를 입력하세요.";
		// 암호화 해줄 BCryptPasswordEncoder 객체 생성
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// dao의 login 메서드를 호출해 DB에서 조회하고 DTO를 반환받아 변수 저장
		LoginDTO check = dao.loginProc(login);
		// matches 메서드로 입력받은 pw와 DB에 저장된 암호화 pw랑 비교
		if (check != null && encoder.matches(login.getPw(), check.getPw())) {
			// 로그인 성공 시 session에 정보들을 넣어줌
			session.setAttribute("id", check.getId());
			return "로그인 완료";
		}
		else
			return "아이디 또는 비밀번호를 확인하세요.";
	}

	@Override
	public ArrayList<MemberDTO> list() {
		return dao.list();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
