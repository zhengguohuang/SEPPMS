package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.Reply;
import cn.edu.hyit.seppms.domain.Topic;
import cn.edu.hyit.seppms.service.ReplyService;
import cn.edu.hyit.seppms.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TopicController {
    @Resource(name = "topicService")
    private TopicService ts;
    @Resource(name = "replyService")
    private ReplyService rs;
    /**
     * 查询所有topic
     * @param m
     * @return
     */
    @RequestMapping("/topic/findAllTopic")
    public String findAll(Model m){
        List<Topic> list = ts.selectAll();
        m.addAttribute("list", list);

        return "/topic/topic";
    }

    /**
     * 显示topic详情
     * @param m
     * @return
     */
    @RequestMapping("/topic/topicDetail")
    public String topicDetail(Model m, @RequestParam("tid") Integer tid){
        Topic topic = ts.selectOne(tid);
        m.addAttribute("topic", topic);

        // 获得话题的所有回复
        List<Reply> replies = rs.selectAllReplyByTopicId(tid);
        m.addAttribute("replies", replies);

        return "/topic/topicDetail";
    }

}
