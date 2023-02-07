package com.pdfgenerator.PDFGenerator.beans;

import java.lang.String;
import org.springframework.stereotype.Component;

@Component
public class DataBean {

	
	public DataBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String title;
	private String content;
	public DataBean(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
