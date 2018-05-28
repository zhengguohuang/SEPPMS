package cn.edu.hyit.seppms.domain;
public class reply {
	private Integer id;
	private Integer userid;
	private Integer topicid;
	private String content;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserid() {
		return userid;
	}
	
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public Integer getTopicid() {
		return topicid;
	}
	
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
