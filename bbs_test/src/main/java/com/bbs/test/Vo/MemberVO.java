package com.bbs.test.Vo;

public class MemberVO {
	String member_id = "";
	String member_pw = "";
	String member_useyn = "";
	String join_date = "";
	String modify_date = "";
	String member_nid = "";
	

	public MemberVO(){
		
	}
	
	public MemberVO(String member_id, String member_pw, String member_useyn,String join_date, String modify_date, String member_nid){
		this.member_id=member_id;
		this.member_pw=member_pw;
		this.member_useyn=member_useyn;
		this.join_date=join_date;
		this.modify_date=modify_date;
		this.member_nid=member_nid;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_useyn() {
		return member_useyn;
	}

	public void setMember_useyn(String member_useyn) {
		this.member_useyn = member_useyn;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	
	public String getMember_nid() {
		return member_nid;
	}
	
	public void setMember_nid(String member_nid) {
		this.member_nid = member_nid;
	}

}
