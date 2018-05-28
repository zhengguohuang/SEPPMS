
public class teacher_task {
	//主键id
	private Integer id;
	//老师id
	private Integer teacherid;
	//任务内容
	private String task;
	//任务书url
	private String mandate;
	//任务大纲
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
