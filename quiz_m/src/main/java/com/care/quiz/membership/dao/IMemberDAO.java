package com.care.quiz.membership.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.quiz.membership.dto.LoginDTO;
import com.care.quiz.membership.dto.MemberDTO;
import com.care.quiz.membership.dto.PostcodeDTO;

@Repository
public interface IMemberDAO {
	
	public int isExistId(String id);

	public int memberProc(MemberDTO member);
	
	public int insertLogin(LoginDTO login);

	public LoginDTO loginProc(LoginDTO login);

	public void insertMember(MemberDTO member);

	public void insertPost(PostcodeDTO post);
	
	public ArrayList<MemberDTO> memberList();
	
}
