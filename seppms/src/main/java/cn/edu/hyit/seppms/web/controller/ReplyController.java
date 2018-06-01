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
public class ReplyController {
    @Resource(name = "replyService")
    private ReplyService rs;

    @Resource(name = "userService")
    private UserService us;

    /**
     * 发表评论
     * @param m
     * @return
     */
    @RequestMapping("/topic/reply")
    public String topicDetail(Model m, @RequestParam("tid") Integer tid, @RequestParam("content") String content){
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String number = (String) subject.getPrincipal();
        // 通过用户名取到用户id
        User user = us.selectByNumber(number);
        // 用户id
        int id = user.getId();
        // 创建评论时间
        Date date=new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        Reply reply = new Reply();
        reply.setTopicId(tid);
        reply.setContent(content);
        reply.setCreateTime(sqldate);
        reply.setUser(user);
        rs.insert(reply);
        return "redirect:/topic/topicDetail"+"?tid="+tid;
    }

}
