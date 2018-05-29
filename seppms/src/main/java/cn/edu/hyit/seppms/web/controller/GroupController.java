package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.GroupInfo;
import cn.edu.hyit.seppms.service.GroupInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GroupController {
    @Resource(name = "groupInfoService")
    private GroupInfoService gs;

    @RequestMapping("/group/findAll")
    public String findAll(Model m){
        List<GroupInfo> list = gs.selectAll();
        m.addAttribute("groups", list);
        System.out.println(list.get(0).getCreateTime());
        return "/group/showGroups";
    }
}
