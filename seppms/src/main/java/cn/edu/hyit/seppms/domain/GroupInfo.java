package cn.edu.hyit.seppms.domain;

public class GroupInfo {
	private int id;
	private String name;
	private int leaderid;
	private int teacherid;
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLeaderid() {
		return leaderid;
	}
	public void setLeaderid(int leaderid) {
		this.leaderid = leaderid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
