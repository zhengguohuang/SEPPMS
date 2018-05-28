package cn.edu.hyit.seppms.domain;

import java.sql.Date;

public class Mark {
    // 主键id
    private Integer id;
    // 评分老师id
    private String teacherid;
    // 学生id
    private String studentid;
    // 平时成绩
    private String daily;
    // 答辩成绩
    private String reply;
    // 文档成绩
    private String document;
	/**
	 * @return the teacherid
	 */
	public String getTeacherid() {
		return teacherid;
	}
	/**
	 * @param teacherid the teacherid to set
	 */
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the studentid
	 */
	public String getStudentid() {
		return studentid;
	}
	/**
	 * @param studentid the studentid to set
	 */
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	/**
	 * @return the daily
	 */
	public String getDaily() {
		return daily;
	}
	/**
	 * @param daily the daily to set
	 */
	public void setDaily(String daily) {
		this.daily = daily;
	}
	/**
	 * @return the reply
	 */
	public String getReply() {
		return reply;
	}
	/**
	 * @param reply the reply to set
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}



}