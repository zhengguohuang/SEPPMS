
public class reply {
	//主键id
	private Integer id;
	//回复者
	private Integer userid;
	//话题id
	private Integer topicid;
	//回复内容
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
