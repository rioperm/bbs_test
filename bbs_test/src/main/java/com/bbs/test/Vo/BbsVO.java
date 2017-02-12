package com.bbs.test.Vo;

public class BbsVO {
	private String bbs_id;
	private String bbs_title;
	private String bbs_content;
	private String bbs_date;
	private String bbs_useyn;
	
	public BbsVO(){
		
	}
	
	public BbsVO(String bbs_id, String bbs_title, String bbs_content, String bbs_date, String bbs_useyn){
		this.bbs_id=bbs_id;
		this.bbs_title=bbs_title;
		this.bbs_content=bbs_content;
		this.bbs_date=bbs_date;
		this.bbs_useyn=bbs_useyn;
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
	
	
}
