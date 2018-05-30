package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.LeaderTask;
import cn.edu.hyit.seppms.domain.TeacherTask;
import cn.edu.hyit.seppms.service.LeaderTaskService;
import cn.edu.hyit.seppms.service.TeacherTaskService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LeaderTaskController {
    @Resource(name = "leaderTaskService")
    private LeaderTaskService lts;

    /**
     * 查询所有组长分配给组员的阶段 任务
     * @param m
     * @return
     */
    @RequestMapping("/info/findAllLeaderTask")
    public String findAll(Model m){
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String number = (String) subject.getPrincipal();
        List<LeaderTask> list = lts.selectAllLeaderTaskByMemberNumber(number);
        m.addAttribute("list", list);
        return "/info/leaderTasks";
    }
}
