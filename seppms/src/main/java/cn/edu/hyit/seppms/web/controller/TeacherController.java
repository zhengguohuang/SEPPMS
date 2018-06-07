package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.Belong;
import cn.edu.hyit.seppms.domain.Relation;
import cn.edu.hyit.seppms.domain.Role;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.BelongService;
import cn.edu.hyit.seppms.service.RelationService;
import cn.edu.hyit.seppms.service.RoleService;
import cn.edu.hyit.seppms.service.UserService;
import cn.edu.hyit.seppms.util.MailUtil;
import cn.edu.hyit.seppms.util.ToolUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class TeacherController {
    private static final String DEFAULT_AVATAR = "../img/qq_small.jpg";

    @Resource(name = "userService")
    private UserService us;

    @Resource(name = "relationService")
    private RelationService rs;
    @Resource(name = "roleService")
    private RoleService ros;
    @Resource(name = "belongService")
    private BelongService bs;


    /**
     *
     */
    @RequestMapping(value = "/teacher/toMarkManager", produces = "application/json;charset=utf-8")
    public String toMarkManager(Model m){
        List<Belong> belong = bs.selectAllStudent();
        m.addAttribute("belong", belong);
        return "/teacher/clients";
    }

    /**
     *
     */
    @RequestMapping(value = "/teacher/toTeacherTask", produces = "application/json;charset=utf-8")
    public String toTeacherTask(Model m, User user){
        return "/teacher/teacherTask";
    }


    /**
     *
     */
    @RequestMapping(value = "/teacher/toUpFilePage", produces = "application/json;charset=utf-8")
    public String toUpFilePage(Model m, User user){
        return "/teacher/submitTeacherTaskFile";
    }
}
