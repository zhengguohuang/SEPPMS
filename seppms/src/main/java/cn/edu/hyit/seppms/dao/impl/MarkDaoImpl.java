package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Mark;
import cn.edu.hyit.seppms.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("markDao")
public class MarkDaoImpl extends SqlSessionDaoSupport implements BaseDao<Mark> {


    @Override
    public Boolean insert(Mark mark) {
        return null;
    }

    @Override
    public Boolean update(Mark mark) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Mark selectOne(Integer id) {
        return null;
    }

    @Override
    public List<Mark> selectAll() {
        return null;
    }

    @Override
    public List<Mark> selectPage(int offset, int len) {
        return null;
    }

    @Override
    public int selectCount() {
        return 0;
    }

    public Mark selectOneByStudentId(Integer studentId) {
        return getSqlSession().selectOne("mark.selectOneByStudentId", studentId);
    }

    public int getDailyAvg() {
        return getSqlSession().selectOne("mark.getDailyAvg");
    }

    public int getReplyAvg() {
        return getSqlSession().selectOne("mark.getReplyAvg");
    }

    public int getDocumentAvg() {

        return getSqlSession().selectOne("mark.getDocumentAvg");
    }
}
