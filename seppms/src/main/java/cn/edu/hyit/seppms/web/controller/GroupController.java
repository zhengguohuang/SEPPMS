package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.GroupInfo;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.GroupInfoService;
import cn.edu.hyit.seppms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GroupController {
    @Resource(name = "groupInfoService")
    private GroupInfoService gs;

    @Resource(name = "userService")
    private UserService us;

    /**
     * 列出所有的组
     * @param m
     * @return
     */
    @RequestMapping("/group/findAll")
    public String findAll(Model m){
        List<GroupInfo> list = gs.selectAll();
        m.addAttribute("groups", list);
        System.out.println(list.get(0).getCreateTime());
        return "/group/showGroups";
    }

    /**
     * 查看组的详情
     * @param m
     * @param gid
     * @return
     */
    @RequestMapping("/group/groupDetail")
    public String groupDetail(Model m, @RequestParam("gid") Integer gid){
        GroupInfo group = gs.selectOne(gid);
        m.addAttribute("group", group);
        return "/group/groupDetail";
    }


    /**
     * 查看组成员详情
     * @param m
     * @param mnumber
     * @return
     */
    @RequestMapping("/group/groupMemberDetail")
    public String groupMemberDetail(Model m, @RequestParam("mnumber") String mnumber){
        User member = us.selectByNumber(mnumber);
        m.addAttribute("mumber", member);
        return "/group/groupMemberDetail";
    }

}
