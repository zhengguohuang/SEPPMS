package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Relation;
import cn.edu.hyit.seppms.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("relationDao")
public class RelationDaoImpl extends SqlSessionDaoSupport implements BaseDao<Relation> {


    public void insert(Relation relation) {

    }

    public void update(Relation relation) {

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
