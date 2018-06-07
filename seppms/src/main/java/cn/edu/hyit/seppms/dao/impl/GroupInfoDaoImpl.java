package cn.edu.hyit.seppms.dao.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.GroupInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("groupInfoDao")
public class GroupInfoDaoImpl extends SqlSessionDaoSupport implements BaseDao<GroupInfo> {
    public Boolean insert(GroupInfo groupInfo) {
        int result = getSqlSession().insert("group_info.insert", groupInfo);
        if(result > 0){
            return true;
        }
        return false;
    }

    public Boolean update(GroupInfo groupInfo) {

        int rows = getSqlSession().update("group_info.update", groupInfo);
        if (rows>0){
            return true;
        }
        return false;
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

    public GroupInfo selectByLeaderId(Integer id) {
        return getSqlSession().selectOne("group_info.selectByLeaderId", id);
    }

    public int selectGroupIdByLeaderId(Integer id) {
        return getSqlSession().selectOne("group_info.selectGroupIdByLeaderId", id);
    }
}
