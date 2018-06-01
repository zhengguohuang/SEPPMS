package cn.edu.hyit.seppms.service;


import cn.edu.hyit.seppms.domain.Reply;

import java.util.List;

public interface ReplyService extends BaseService<Reply> {
    public List<Reply> selectAllReplyByTopicId(Integer tid);

    public int countReplyByTopicId(Integer tid);
    // Reply的共有方法放在这里
}
