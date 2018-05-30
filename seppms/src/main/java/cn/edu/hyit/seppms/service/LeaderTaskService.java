package cn.edu.hyit.seppms.service;


import cn.edu.hyit.seppms.domain.LeaderTask;

import java.util.List;

public interface LeaderTaskService extends BaseService<LeaderTask> {
    List<LeaderTask> selectAllLeaderTaskByMemberNumber(String number);
    // LeaderTask的共有方法放在这里

}
