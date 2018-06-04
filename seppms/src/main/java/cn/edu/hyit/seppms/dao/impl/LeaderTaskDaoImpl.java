package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.LeaderTask;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("leaderTaskDao")
public class LeaderTaskDaoImpl extends SqlSessionDaoSupport implements BaseDao<LeaderTask> {

    public Boolean insert(LeaderTask leaderTask) {

        return null;
    }

    public Boolean update(LeaderTask leaderTask) {

        return null;
    }

    public void delete(Integer id) {

    }

    public LeaderTask selectOne(Integer id) {
        return getSqlSession().selectOne("leader_task.selectOne", id);
    }

    public List<LeaderTask> selectAll() {
        return null;
    }

    public List<LeaderTask> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }

    public List<LeaderTask> selectAllLeaderTaskByMemberNumber(String number) {
        return getSqlSession().selectList("leader_task.selectAllLeaderTaskByMemberNumber", number);
    }
}
