package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.Reply;
import cn.edu.hyit.seppms.domain.Topic;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.ReplyService;
import cn.edu.hyit.seppms.service.TopicService;
import cn.edu.hyit.seppms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class TopicController {
    @Resource(name = "topicService")
    private TopicService ts;
    @Resource(name = "replyService")
    private ReplyService rs;
    @Resource(name = "userService")
    private UserService us;
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
    /**
     * 跳到添加Topic界面
     * @param
     * @return
     */
    @RequestMapping("/topic/toAddTopic")
    public String topicDetail(){
        return "/topic/addTopic";
    }

    /**
     * 添加Topic
     * @param
     * @return
     */
    @RequestMapping("/topic/doAddTopic")
    public String dopicDetail(Topic topic){
        // 创建评论时间
        Date date=new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        topic.setCreateTime(sqldate);
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String number = (String) subject.getPrincipal();
        // 通过用户名取到用户id
        User user = us.selectByNumber(number);
        topic.setUser(user);
        ts.insert(topic);
        return "redirect:/topic/findAllTopic";
    }
}
