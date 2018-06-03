package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.MarkDaoImpl;
import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.*;
import cn.edu.hyit.seppms.service.MarkService;
import cn.edu.hyit.seppms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("markService")
public class MarkServiceImpl extends BaseServiceImpl<Mark> implements MarkService {
    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "markDao")
    public void setDao(BaseDao<Mark> dao) {
        super.setDao(dao);
    }

    @Resource(name = "markDao")
    private MarkDaoImpl dao;


    @Override
    public Mark selectOneByStudentId(Integer studentId) {
        return dao.selectOneByStudentId(studentId);
    }

    @Override
    public int getDailyAvg() {
        return dao.getDailyAvg();
    }

    @Override
    public int getReplyAvg() {
        return dao.getReplyAvg();
    }

    @Override
    public int getDocumentAvg() {
        return dao.getDocumentAvg();
    }
}
