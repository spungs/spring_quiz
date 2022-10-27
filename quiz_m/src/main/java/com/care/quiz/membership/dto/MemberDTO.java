package com.care.quiz.membership.dto;
/*
CREATE TABLE spring_quiz(
id varchar2(20),
pw varchar2(60),
email varchar2(100),
address varchar2(500),
gender varchar2(15),
PRIMARY KEY(id)
);


commit;
 */

public class MemberDTO {
	private String id;
	private String pw;
	private String pwOk;
	private String email;
	private String addr1;
	private String addr2;
	private String address;
	private String gender;
	private String authNum;
	private String zipcode;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAuthNum() {
		return authNum;
	}

	public void setAuthNum(String authNum) {
		this.authNum = authNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwOk() {
		return pwOk;
	}

	public void setPwOk(String pwOk) {
		this.pwOk = pwOk;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
