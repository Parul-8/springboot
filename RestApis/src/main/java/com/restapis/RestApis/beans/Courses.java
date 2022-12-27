package com.restapis.RestApis.beans;

public class Courses {
	
	private long id;
	private String title;
	private String desc;
	
	public Courses(long id,String title,String desc) {
		this.id = id;
		this.title = title;
		this.desc = desc;
	}
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return this.desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
