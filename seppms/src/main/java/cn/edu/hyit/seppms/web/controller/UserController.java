package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.Relation;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.RelationService;
import cn.edu.hyit.seppms.service.UserService;
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
public class UserController {

    @Resource(name = "userService")
    private UserService us;

    @Resource(name = "relationService")
    private RelationService rs;
    @RequestMapping("/user/findall")
    public String findAll(Model m){
        List<User> list = us.selectAll();
        m.addAttribute("users", list);
        return "/user/userList";
    }

    @RequestMapping("/user/findone")
    public String findOne(Model m, @RequestParam("uid") Integer uid){
        User user = us.selectOne(uid);
        m.addAttribute("user", user);
        return "/user/oneUser";
    }

    @RequestMapping("/user/deleteUser")
    public String delete(@RequestParam("uid") Integer uid){
        us.delete(uid);
        System.out.println("delete uid = " + uid);
        return "redirect:/user/findall";
    }

    @RequestMapping("/user/editUser")
    public String edit(Model m){
        return "user/userEdit";
    }

    @RequestMapping("/user/hello")
    public String accessHtml(Model m){
        return "forward:/html/hello.html";
    }

    @RequestMapping(value = "/user/userSave", method = RequestMethod.POST)
    public String saveUser(User u){
        us.save(u);
        return "redirect:/user/findall";
    }

    @RequestMapping(value = "/user/toAddUserPage")
    public String toAddUserPage(){
        return "user/userEdit";
    }

    @RequestMapping(value = "/user/findPage")
    public String findPage(Model m, @RequestParam("pn") int pn){

        // 总记录数
        int counts = us.selectCount();

        // 每页记录数
        int recordPerPage = 5;

        // 偏移量
        int offset = (pn - 1) * recordPerPage;

        // 计算页数
        int pages = 0;
        if(counts % recordPerPage == 0){
            pages = counts / recordPerPage;
        }
        else {
            pages = counts / recordPerPage + 1;
        }
        List<User> list = us.selectPage(offset, recordPerPage);
        m.addAttribute("users", list);
        m.addAttribute("pages", pages);
        return "user/userList";
    }





    /**
     * shiro 权限控制
     * @param user
     * , produces = "application/json;charset=utf-8"
     * @return
     */
    @RequestMapping(value = "/home")
    public String subLogin(Model m, User user){
        User u = us.selectByNumber(user.getNumber());
        List<Relation> relations = rs.selectAllByNumber(u.getNumber());
        m.addAttribute("relations", relations);
        m.addAttribute("user", u);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNumber(), user.getPassword());
        try {
            subject.login(token);
        }
        catch (Exception e){
            return e.getMessage();
        }
        return "/user/home";
//        if (subject.hasRole("admin")){
////            return "有admin权限";
////        }
////        return "无admin权限";
    }

    @RequestMapping(value = "/user/toRegPage")
    public String toRegPage(){
        return "user/register";
    }

    /**
     */
    @RequestMapping(value = "/doReg", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String doReg(User user){
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), user.getNumber());//a81082604404c078e80f8bf501133abe
        user.setPassword(md5Hash.toString());
        Date date=new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        user.setCreateTime(sqldate);
        // 插入数据库
        us.insert(user);
        System.out.println(user.getNumber() + "\t" + user.getPassword());
        // 重定向登录页
        return "redirect:/";
    }

    /**
     */
    @RequestMapping(value = "/empty", produces = "application/json;charset=utf-8")
    public String empty(){
        return "empty_page";
    }

    /**
     * 个人资料
     */
    @RequestMapping(value = "/user/profile", produces = "application/json;charset=utf-8")
    public String profile(Model m){
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String number = (String) subject.getPrincipal();
        User user = us.selectByNumber(number);
        m.addAttribute("user", user);

        return "/user/profile";
    }

    /**
     * 获得角色菜单,目前用于测试，完成后集成到/home中
     */
    @RequestMapping(value = "/user/getMenu", produces = "application/json;charset=utf-8")
    public String getMenu(Model m){
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String number = (String) subject.getPrincipal();
        List<Relation> relations = rs.selectAllByNumber(number);
        m.addAttribute("relations", relations);

        return "/user/home2";
    }

    /**
     * 修改头像
     */
    @RequestMapping(value = "/user/changeAvatar", produces = "application/json;charset=utf-8")
    public String changeAvatar(Model m){
//        //获取当前用户名
//        Subject subject = SecurityUtils.getSubject();
//        String number = (String) subject.getPrincipal();
//        List<Relation> relations = rs.selectAllByNumber(number);
//        m.addAttribute("relations", relations);

        return "/user/changeAvatar";
    }

    /**
     * 修改资料
     */
    @RequestMapping(value = "/user/editProfile", produces = "application/json;charset=utf-8")
    public String editProfile(Model m){
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String number = (String) subject.getPrincipal();
//        List<Relation> relations = rs.selectAllByNumber(number);
//        m.addAttribute("relations", relations);
        User user = us.selectByNumber(number);
        m.addAttribute("user", user);
        return "/user/editProfile";
    }

    /**
     * 提交修改
     */
    @RequestMapping(value = "/user/doEditProfile", produces = "application/json;charset=utf-8")
    public String doEditProfile(Model m, User user){
        Subject subject = SecurityUtils.getSubject();
        String number = (String) subject.getPrincipal();
        user.setNumber(number);
        Boolean isSuccess = us.updateByNumber(user);
        if (isSuccess){
            return "redirect:/user/profile";
        }else {
            return "/fail";
        }
    }
}
