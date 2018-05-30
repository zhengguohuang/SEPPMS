package cn.edu.hyit.seppms.domain;

public class MemberUpFile {
    private Integer id;
    private int leaderTaskId;
    private int fileId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLeaderTaskId() {
        return leaderTaskId;
    }

    public void setLeaderTaskId(int leaderTaskId) {
        this.leaderTaskId = leaderTaskId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}
