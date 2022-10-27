package com.care.quiz.membership.dao;

import org.springframework.stereotype.Repository;

import com.care.quiz.membership.dto.MemberDTO;

@Repository
public interface IMemberDAO {
	public int IsExistId(String id);

	public int memberProc(MemberDTO member);
	
	public int insert(MemberDTO member);

	public MemberDTO login(MemberDTO member);
	
	
}
