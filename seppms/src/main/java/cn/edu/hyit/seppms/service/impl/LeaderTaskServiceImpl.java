package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.LeaderTaskDaoImpl;
import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.Item;
import cn.edu.hyit.seppms.domain.LeaderTask;
import cn.edu.hyit.seppms.domain.Order;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.LeaderTaskService;
import cn.edu.hyit.seppms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("leaderTaskService")
public class LeaderTaskServiceImpl extends BaseServiceImpl<LeaderTask> implements LeaderTaskService {


    @Resource(name = "leaderTaskDao")
    private LeaderTaskDaoImpl dao;

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "leaderTaskDao")
    public void setDao(BaseDao<LeaderTask> dao) {
        super.setDao(dao);
    }


    public List<LeaderTask> selectAllLeaderTaskByMemberNumber(String number) {
        return dao.selectAllLeaderTaskByMemberNumber(number);
    }
}
