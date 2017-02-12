package com.bbs.test.Vo;

public class MemberVO {
	String memberId = "";
	String memberPw = "";
	String memberUseyn = "";
	
	public MemberVO(String memberId, String memberPw, String memberUseyn){
		this.memberId=memberId;
		this.memberPw=memberPw;
		this.memberUseyn=memberUseyn;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberUseyn() {
		return memberUseyn;
	}

	public void setMemberUseyn(String memberUseyn) {
		this.memberUseyn = memberUseyn;
	}
	
}
