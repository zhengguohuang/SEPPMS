package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.LeaderTask;
import cn.edu.hyit.seppms.domain.Reply;
import cn.edu.hyit.seppms.domain.Topic;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("topicDao")
public class TopicDaoImpl extends SqlSessionDaoSupport implements BaseDao<Topic> {

    public void insert(Topic topic) {
        getSqlSession().insert("topic.insert", topic);
    }

    public void update(Topic topic) {

    }

    public void delete(Integer id) {

    }

    public Topic selectOne(Integer id) {
        return getSqlSession().selectOne("topic.selectOne", id);
    }

    public List<Topic> selectAll() {
        return getSqlSession().selectList("topic.selectAll");
    }

    public List<Topic> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }

}
