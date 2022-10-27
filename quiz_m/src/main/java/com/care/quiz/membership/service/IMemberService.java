package com.care.quiz.membership.service;

import java.util.ArrayList;

import com.care.quiz.membership.dto.LoginDTO;
import com.care.quiz.membership.dto.MemberDTO;
import com.care.quiz.membership.dto.PostcodeDTO;

public interface IMemberService {

	// 아이디 중복 확인
	public String isExistId(String id);
	
	// 회원 가입
	public String memberProc(MemberDTO member, PostcodeDTO post);
	
	// 로그인
	public String loginProc(LoginDTO login);

	public ArrayList<MemberDTO> list();
}
