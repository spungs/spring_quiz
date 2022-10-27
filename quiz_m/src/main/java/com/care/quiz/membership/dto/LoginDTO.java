package com.care.quiz.membership.dto;

/*
CREATE TABLE login(
 id varchar2(20),
 pw varchar2(128),
 CONSTRAINT pk_login PRIMARY KEY (id)
)
*/

public class LoginDTO {
	private String id;
	private String pw;
	private String pwOk;
	private String authNum;

	public String getAuthNum() {
		return authNum;
	}

	public void setAuthNum(String authNum) {
		this.authNum = authNum;
	}

	public String getPwOk() {
		return pwOk;
	}

	public void setPwOk(String pwOk) {
		this.pwOk = pwOk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
