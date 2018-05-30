package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.TeacherTask;
import cn.edu.hyit.seppms.service.TeacherTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TeacherTaskController {
    @Resource(name = "teacherTaskService")
    private TeacherTaskService tts;

    /**
     * 查询所有任务书
     * @param m
     * @return
     */
    @RequestMapping("/info/findAllMandate")
    public String findAll(Model m){
//        List<GroupInfo> list = gs.selectAll();
//        m.addAttribute("groups", list);
//        System.out.println(list.get(0).getCreateTime());
        List<TeacherTask> list = tts.selectAll();
        m.addAttribute("list", list);
        return "/info/fileManager";
    }
}
