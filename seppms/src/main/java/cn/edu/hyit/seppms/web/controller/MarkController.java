package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.LeaderTask;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class MarkController {

    @RequestMapping("/info/findMark")
    public String findAll(Model m){
//        //获取当前用户名
//        Subject subject = SecurityUtils.getSubject();
//        String number = (String) subject.getPrincipal();
//        List<LeaderTask> list = lts.selectAllLeaderTaskByMemberNumber(number);
//        m.addAttribute("list", list);
        return "/info/testMark";
    }
}
