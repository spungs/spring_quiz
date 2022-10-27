package com.care.quiz.membership.service;

import com.care.quiz.membership.dto.MemberDTO;
import com.care.quiz.membership.dto.PostcodeDTO;

public interface IMemberService {

	// 아이디 중복 확인
	public String IsExistId(String id);
	
	// 회원 가입
	public String insert(MemberDTO member);
	
	public String memberProc(MemberDTO member, PostcodeDTO post);

	public String login(MemberDTO member);
}
