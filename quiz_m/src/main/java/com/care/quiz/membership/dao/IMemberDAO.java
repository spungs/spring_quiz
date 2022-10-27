package com.care.quiz.membership.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.quiz.membership.dto.LoginDTO;
import com.care.quiz.membership.dto.MemberDTO;

@Repository
public interface IMemberDAO {
	public int isExistId(String id);

	public int memberProc(MemberDTO member);
	
	public int insertLogin(LoginDTO login);

	public LoginDTO loginProc(LoginDTO login);

	public ArrayList<MemberDTO> list();
	
	
}
