package cn.edu.hyit.seppms.domain;

public class TeacherUpFile {
    private Integer id;
    private int teacherTaskId;
    private int fileId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public int getTeacherTaskId() {
        return teacherTaskId;
    }

    public void setTeacherTaskId(int teacherTaskId) {
        this.teacherTaskId = teacherTaskId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}
