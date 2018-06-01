package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.ReplyDaoImpl;
import cn.edu.hyit.seppms.domain.Reply;
import cn.edu.hyit.seppms.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("replyService")
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService {

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "replyDao")
    public void setDao(BaseDao<Reply> dao) {
        super.setDao(dao);
    }

    @Resource(name = "replyDao")
    private ReplyDaoImpl dao;


    public List<Reply> selectAllReplyByTopicId(Integer tid) {
        return dao.selectAllReplyByTopicId(tid);
    }

    public int countReplyByTopicId(Integer tid) {
        return dao.countReplyByTopicId(tid);
    }
}
