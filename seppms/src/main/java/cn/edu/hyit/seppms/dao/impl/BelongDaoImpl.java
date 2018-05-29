package cn.edu.hyit.seppms.dao.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Belong;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("belongDao")
public class BelongDaoImpl extends SqlSessionDaoSupport implements BaseDao<Belong> {
    public void insert(Belong belong) {

    }

    public void update(Belong belong) {

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
}
