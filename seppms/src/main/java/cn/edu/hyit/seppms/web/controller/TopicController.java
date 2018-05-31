package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.LeaderTask;
import cn.edu.hyit.seppms.domain.Topic;
import cn.edu.hyit.seppms.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TopicController {
    @Resource(name = "topicService")
    private TopicService ts;

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
}
