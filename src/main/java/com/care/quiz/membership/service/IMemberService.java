package com.care.quiz.membership.service;

import com.care.quiz.membership.dto.MemberDTO;

public interface IMemberService {

	// 아이디 중복 확인
	public String IsExistId(String id);
	
	// 회원 가입
	public String insert(MemberDTO member);
	
	// 로그인
	public String login(MemberDTO member);
}
