package com.care.quiz.membership.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.quiz.membership.dao.IMemberDAO;
import com.care.quiz.membership.dto.MemberDTO;
import com.care.quiz.membership.dto.PostcodeDTO;

@Service
public class MemberServiceImpl implements IMemberService {
	@Autowired IMemberDAO dao;
	@Autowired HttpSession session;
	
	@Override
	public String IsExistId(String id) {
		if(dao.IsExistId(id) == 0) {
			// 회원가입 시 중복 체크를 했는지 확인하기 위한 session
			session.setAttribute("IsExistId", "y");
			return "사용가능한 아이디입니다.";
		}
		// 사용가능한 아이디 체크했다가 중복 아이디로 체크 시 session이 없어야하기 때문에 invalidate
		session.invalidate();
		return "중복 아이디입니다.";
	}

	@Override
	public String memberProc(MemberDTO member, PostcodeDTO post) {
//		if(dao.memberProc(member, post) == 0)
//			return "가입 실패. 다시 이용해주세요.";
		
		return "가입 완료";
	}

	@Override
	public String insert(MemberDTO member) {
		
		// 모두 입력했는지 체크하는 if문 (parameter로 null이 전달되면 공백이라 isEmpty 사용)
		if(member.getPw().isEmpty() || member.getId().isEmpty() || member.getPwOk().isEmpty()) {
			return "모두 입력해주세요.";
		}
		// 입력한 pw랑 poWk가 같은지 확인하는 if문
		if(member.getPw().equals(member.getPwOk()) == false) {
			return "입력하신 두 비밀번호가 일치하지 않습니다.";
		}
		// 아이디 중복 체크 했는지 확인하는 if문
		if(session.getAttribute("IsExistId") == null) {
			return "아이디 중복 확인 해주세요.";
		}
		// 주소와 상세주소 합치기 위한 setter
		member.setAddress(member.getAddr1() + " " + member.getAddr2());
		System.out.println("address : " + member.getAddress());
		
		// 비밀번호 암호화
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String cipherPassword = encoder.encode(member.getPw());
		member.setPw(cipherPassword);
		if(dao.insert(member) == 0) {
			return "가입 실패";
		}
		else
			return "가입 완료";
		
	}

	@Override
	public String login(MemberDTO member) {
		// 입력여부 검증
		if(member.getId().isEmpty() || member.getPw().isEmpty())
			return "아이디 / 비밀번호 모두 입력해주세요.";
		// dao의 login 메서드를 호출해 DB에서 조회하고 DTO를 반환받아 변수 저장
		MemberDTO m = dao.login(member);
		// BCryptPasswordEncoder 객체 생성
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// matches 메서드로 입력받은 pw와 DB에 저장된 암호화 pw랑 비교
		if (encoder.matches(member.getPw(), m.getPw()) == false) {
			return "로그인 정보가 일치하지 않습니다. 확인 후 다시 입력해주세요.";
		}
		else
			return "로그인 완료";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
