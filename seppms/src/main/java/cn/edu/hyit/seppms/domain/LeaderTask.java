package cn.edu.hyit.seppms.domain;

public class LeaderTask {

    private Integer id;
    private String task;
    private int memberId;
    private int processId;
    private int leaderId;
    private String upFile;

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

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getUpFile() {
        return upFile;
    }

    public void setUpFile(String upFile) {
        this.upFile = upFile;
    }
}
