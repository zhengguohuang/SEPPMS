package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Relation;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("relationDao")
public class RelationDaoImpl extends SqlSessionDaoSupport implements BaseDao<Relation> {


    public Boolean insert(Relation relation) {

        return null;
    }

    public Boolean update(Relation relation) {

        return null;
    }

    public void delete(Integer id) {

    }

    public Relation selectOne(Integer id) {
        return null;
    }

    public List<Relation> selectAll() {
        return null;
    }

    public List<Relation> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }

    public List<Relation> selectAllByNumber(String number) {
        return getSqlSession().selectList("sys_relation.selectAllByNumber", number);
    }
}
