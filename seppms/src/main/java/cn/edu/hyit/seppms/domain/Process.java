package cn.edu.hyit.seppms.domain;

import java.sql.Date;

public class Process {
    private Integer id;
    private String name;
    private Date startTime;
    private Date endTime;
    private int groupId;
    private int teacherId;
    private String upFiles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getUpFiles() {
        return upFiles;
    }

    public void setUpFiles(String upFiles) {
        this.upFiles = upFiles;
    }
}
