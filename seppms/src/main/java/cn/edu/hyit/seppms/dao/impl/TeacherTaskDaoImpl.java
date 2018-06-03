package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.TeacherTask;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teacherTaskDao")
public class TeacherTaskDaoImpl extends SqlSessionDaoSupport implements BaseDao<TeacherTask> {


    public Boolean insert(TeacherTask teacherTask) {

        return null;
    }

    public Boolean update(TeacherTask teacherTask) {

        return null;
    }

    public void delete(Integer id) {

    }

    public TeacherTask selectOne(Integer id) {
        return null;
    }

    public List<TeacherTask> selectAll() {
        return getSqlSession().selectList("teacher_task.selectAll");
    }

    public List<TeacherTask> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }
}
