package com.bbs.test.Vo;

public class BbsVO {
	private String bbs_id;
	private String bbs_title;
	private String bbs_content;
	private String bbs_date;
	private String bbs_useyn;
	private String member_nid;
	private String member_id;
	private int totalCount;
	private int startIndex;
	private int numberPerPage;
	
	public BbsVO(){
		
	}
	
	public BbsVO(String bbs_id, String bbs_title, String bbs_content, String bbs_date, String bbs_useyn, String member_nid, String member_id, int totalCount, int startIndex,int numberPerPage){
		this.bbs_id=bbs_id;
		this.bbs_title=bbs_title;
		this.bbs_content=bbs_content;
		this.bbs_date=bbs_date;
		this.bbs_useyn=bbs_useyn;
		this.member_nid=member_nid;
		this.member_id=member_id;
		this.totalCount=totalCount;
		this.startIndex=startIndex;
		this.numberPerPage=numberPerPage;
		
	}

	public String getBbs_id() {
		return bbs_id;
	}

	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}

	public String getBbs_title() {
		return bbs_title;
	}

	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}

	public String getBbs_content() {
		return bbs_content;
	}

	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}

	public String getBbs_date() {
		return bbs_date;
	}

	public void setBbs_date(String bbs_date) {
		this.bbs_date = bbs_date;
	}

	public String getBbs_useyn() {
		return bbs_useyn;
	}

	public void setBbs_useyn(String bbs_useyn) {
		this.bbs_useyn = bbs_useyn;
	}
	
	public String getMember_nid() {
		return member_nid;
	}
	
	public void setMember_nid(String member_nid) {
		this.member_nid = member_nid;
	}
	
	public String getMember_id() {
		return member_id;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getNumberPerPage() {
		return numberPerPage;
	}

	public void setNumberPerPage(int numberPerPage) {
		this.numberPerPage = numberPerPage;
	}

		
}
