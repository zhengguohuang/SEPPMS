package cn.edu.hyit.seppms.domain;
public class TeacherTask {
	private Integer id;
	private Integer teacherid;
	private String task;
	private String mandate;
	private String outline;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getMandate() {
		return mandate;
	}
	
	public void setMandate(String mandate) {
		this.mandate = mandate;
	}
	
	public String getOutline() {
		return outline;
	}
	
	public void setOutline(String outline) {
		this.outline = outline;
	}
}
