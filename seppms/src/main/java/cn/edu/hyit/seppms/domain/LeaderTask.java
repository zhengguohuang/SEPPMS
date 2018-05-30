package cn.edu.hyit.seppms.domain;

import java.util.List;

public class LeaderTask {

    private Integer id;
    // 任务的详细说明
    private String task;
    // 组员id
    private int memberId;
    // 过程id
    private Process process;
    // 组id
    private int groupId;
    // 组员上传作业文件
    private List<File> files;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
