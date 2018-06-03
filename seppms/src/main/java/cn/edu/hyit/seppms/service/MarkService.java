package cn.edu.hyit.seppms.service;


import cn.edu.hyit.seppms.domain.Mark;

public interface MarkService extends BaseService<Mark> {
    public Mark selectOneByStudentId(Integer id);

    public int getDailyAvg();

    public int getReplyAvg();

    public int getDocumentAvg();
    // Mark的共有方法放在这里
}
