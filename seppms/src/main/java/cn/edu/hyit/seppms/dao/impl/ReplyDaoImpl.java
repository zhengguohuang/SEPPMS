package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Reply;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("replyDao")
public class ReplyDaoImpl extends SqlSessionDaoSupport implements BaseDao<Reply> {


    public Boolean insert(Reply reply) {
        int rows = getSqlSession().insert("reply.insert", reply);
        if(rows > 0){
            return true;
        }
        return false;
    }

    public Boolean update(Reply reply) {

        return null;
    }

    public void delete(Integer id) {

    }

    public Reply selectOne(Integer id) {
        return null;
    }

    public List<Reply> selectAll() {
        return null;
    }

    public List<Reply> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }

    public List<Reply> selectAllReplyByTopicId(Integer tid) {
        return getSqlSession().selectList("reply.selectAllReplyByTopicId", tid);
    }

    public int countReplyByTopicId(Integer tid) {
        return getSqlSession().selectOne("reply.countReplyByTopicId", tid);
    }
}
