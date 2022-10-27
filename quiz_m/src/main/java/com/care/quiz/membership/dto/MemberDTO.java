package com.care.quiz.membership.dto;
/*
CREATE TABLE member(
 id varchar2(20),
 gender varchar2(2),
 email varchar2(40),
 CONSTRAINT pk_member FOREIGN KEY (id) REFERENCES login(id) ON DELETE CASCADE
)
*/

public class MemberDTO extends LoginDTO{
	private String email;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
