package com.care.quiz.membership.dto;

/*
CREATE TABLE postcode(
 no number,
 zipcode varchar2(5) not null,
 addr1 varchar2(180),
 addr2 varchar2(20),
 id varchar2(20),
 CONSTRAINT pk_post FOREIGN KEY(id) REFERENCES login(id) ON DELETE CASCADE
)
*/
public class PostcodeDTO {
	private int no;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String id;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
