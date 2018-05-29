package cn.edu.hyit.seppms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherTaskController {

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
        return "/info/fileManager";
    }
}
