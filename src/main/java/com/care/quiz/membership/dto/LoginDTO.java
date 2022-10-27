package com.care.quiz.membership.dto;

/*
SQL> CREATE TABLE login(
 2 id varchar2(20),
 3 pw varchar2(128),
 4 CONSTRAINT pk_login PRIMARY KEY (id)
 5 );
Table created.
SQL> INSERT INTO login VALUES('admin', '1234');
1 row created.
SQL> commit;
Commit complete.
*/

public class LoginDTO {
	private String id;
	private String pw;

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
