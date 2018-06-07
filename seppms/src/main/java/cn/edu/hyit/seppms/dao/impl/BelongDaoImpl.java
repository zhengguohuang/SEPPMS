package cn.edu.hyit.seppms.dao.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Belong;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("belongDao")
public class BelongDaoImpl extends SqlSessionDaoSupport implements BaseDao<Belong> {
    public Boolean insert(Belong belong) {
        int result = getSqlSession().insert("belong.insert", belong);
        if (result>0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean update(Belong belong) {

        return null;
    }

    public void delete(Integer id) {

    }

    public Belong selectOne(Integer id) {
        return null;
    }

    public List<Belong> selectAll() {
        return null;
    }

    public List<Belong> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }

    public int getGroupCountByUserId(Integer userId) {
        return getSqlSession().selectOne("belong.getGroupCountByUserId", userId);
    }

    public List<Belong> selectMemberByLeaderId(Integer id) {
        return getSqlSession().selectList("belong.selectMemberByLeaderId", id);
    }

    public List<Belong> selectAllStudent() {
        return getSqlSession().selectList("belong.selectAllStudent");
    }
}
