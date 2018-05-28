package cn.edu.hyit.seppms.domain;

public class Topic {
	private int id;
	private int useid;
	private String title;
	private String content;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUseid() {
		return useid;
	}
	public void setUseid(int useid) {
		this.useid = useid;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
}
