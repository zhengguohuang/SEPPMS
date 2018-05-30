package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.Item;
import cn.edu.hyit.seppms.domain.Order;
import cn.edu.hyit.seppms.domain.TeacherTask;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.TeacherTaskService;
import cn.edu.hyit.seppms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherTaskService")
public class TeacherTaskServiceImpl extends BaseServiceImpl<TeacherTask> implements TeacherTaskService {

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "teacherTaskDao")
    public void setDao(BaseDao<TeacherTask> dao) {
        super.setDao(dao);
    }

    @Resource(name = "teacherTaskDao")
    private BaseDao<TeacherTask> dao;


}
