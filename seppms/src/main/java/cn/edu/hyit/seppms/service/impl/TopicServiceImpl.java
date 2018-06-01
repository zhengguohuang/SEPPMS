package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.LeaderTaskDaoImpl;
import cn.edu.hyit.seppms.dao.impl.TopicDaoImpl;
import cn.edu.hyit.seppms.domain.LeaderTask;
import cn.edu.hyit.seppms.domain.Reply;
import cn.edu.hyit.seppms.domain.Topic;
import cn.edu.hyit.seppms.service.LeaderTaskService;
import cn.edu.hyit.seppms.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("topicService")
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService {


    @Resource(name = "topicDao")
    private TopicDaoImpl dao;

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "topicDao")
    public void setDao(BaseDao<Topic> dao) {
        super.setDao(dao);
    }

}
