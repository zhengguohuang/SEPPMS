package cn.edu.hyit.seppms.dao.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.GroupInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("groupInfoDao")
public class GroupInfoDaoImpl extends SqlSessionDaoSupport implements BaseDao<GroupInfo> {
    public void insert(GroupInfo groupInfo) {

    }

    public void update(GroupInfo groupInfo) {

    }

    public void delete(Integer id) {

    }

    public GroupInfo selectOne(Integer id) {
        return getSqlSession().selectOne("group_info.selectOne", id);
    }

    public List<GroupInfo> selectAll() {
        return getSqlSession().selectList("group_info.selectAll");
    }

    public List<GroupInfo> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }
}
