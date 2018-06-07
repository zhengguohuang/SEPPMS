package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.Belong;
import cn.edu.hyit.seppms.domain.GroupInfo;
import cn.edu.hyit.seppms.domain.Role;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.BelongService;
import cn.edu.hyit.seppms.service.GroupInfoService;
import cn.edu.hyit.seppms.service.RoleService;
import cn.edu.hyit.seppms.service.UserService;
import cn.edu.hyit.seppms.util.TimeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

    @Resource(name = "belongService")
    private BelongService bs;

    @Resource(name = "roleService")
    private RoleService rs;


    /**
     * 列出所有的组
     * @param m
     * @return
     */
    @RequestMapping("/group/findAll")
    public String findAll(Model m){
        List<GroupInfo> list = gs.selectAll();
        m.addAttribute("groups", list);
        //获取当前用户名
        Subject currentUser = SecurityUtils.getSubject();
        String number = (String) currentUser.getPrincipal();
        User user = us.selectByNumber(number);
        int isHasGroup = bs.getGroupCountByUserId(user.getId());
        boolean isT = currentUser.hasRole("teacher");
        int isTeacher = isT?1:0;
        m.addAttribute("isTeacher", isTeacher);
        m.addAttribute("isHasGroup", isHasGroup);
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

    /**
     * 加入小组
     * @return
     */
    @RequestMapping("/group/joinGroup")
    public String joinGroup(@RequestParam("groupId") int groupId){
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        String number = (String) currentUser.getPrincipal();
        User user = us.selectByNumber(number);

        Belong belong = new Belong();
        belong.setUser(user);
        belong.setGroupId(groupId);

        Boolean isSuccess = bs.insert(belong);
        if (isSuccess){
            return "/group/joinSuccess";
        } else {
            return "/group/joinFail";
        }
    }

    /**
     * 创建小组
     * @return
     */
    @RequestMapping("/group/toCreateGroup")
    public String toCreateGroup(Model m){
        // 查询到所有老师放入下拉列表
        List<Role> teachers = rs.selectAllByRoleName("teacher");
        m.addAttribute("teachers",teachers);
        return "/group/createGroup";
    }

    /**
     * 创建小组
     * @return
     */
    @RequestMapping("/group/doCreateGroup")
    public String doCreateGroup(@RequestParam("name") String name, @RequestParam("teacherid") int teacherid){
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        String number = (String) currentUser.getPrincipal();
        User user = us.selectByNumber(number);
        // 1.更新sys_role表
        Role role = new Role();
        role.setName("leader");
        role.setUser(user);
        rs.update(role);

        // 2.插入组
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setName(name);
        groupInfo.setLeader(user);
        User teacher = new User();
        teacher.setId(teacherid);
        groupInfo.setTeacher(teacher);
        groupInfo.setStatus(0);
        groupInfo.setCreateTime(TimeUtil.getCurrentSQLTime());
        Boolean isSuccess = gs.insert(groupInfo);

        // 3.组长id插入belong
        Belong belong = new Belong();
        belong.setUser(user);
        // 由leaderid查询groupid
//        GroupInfo groupId = gs.selectOne(1);
//        GroupInfo groupId = gs.selectOneByLeaderId(1);
        int groupId = gs.selectGroupIdByLeaderId(user.getId());
        belong.setGroupId(groupId);
        bs.insert(belong);



        if (isSuccess){
            return "/group/joinSuccess";
        } else {
            return "/group/joinFail";
        }
    }

    /**
     * 确认小组
     * @return
     */
    @RequestMapping("/group/checkGroup")
    public String checkGroup(@RequestParam("groupId") Integer groupId){
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setId(groupId);
        groupInfo.setStatus(1);
        gs.update(groupInfo);
        return "redirect:/group/findAll";
    }


    /**
     * 过程管理
     */
    @RequestMapping("/group/toProcessManage")
    public String processManage(Model m, @RequestParam("groupId") Integer groupId){

        GroupInfo group = gs.selectOne(groupId);
        m.addAttribute("group", group);


        return "/group/processManage";
    }

    /**
     * 分配任务
     */
    @RequestMapping("/group/toMemberList")
    public String toCastLeaderTask(Model m){
//        List<User> users = us.selectAll();
//        m.addAttribute("users", users);
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        String number = (String) currentUser.getPrincipal();
        User user = us.selectByNumber(number);
        List<Belong> belongs = bs.selectMemberByLeaderId(user.getId());
        m.addAttribute("belongs", belongs);
        return "/group/members";
    }

    /**
     * 转到组长分配任务页面
     */
    @RequestMapping("/group/toLeaderCastTaskPage")
    public String toLeaderCastTaskPage(Model m, @RequestParam("memberId") int memberId){
        User user = us.selectOne(memberId);
        m.addAttribute("user", user);
        return "/group/castLeaderTask";
    }

}
