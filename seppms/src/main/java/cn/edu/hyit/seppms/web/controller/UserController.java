package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.Relation;
import cn.edu.hyit.seppms.domain.Role;
import cn.edu.hyit.seppms.domain.User;
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
public class UserController {
    private static final String DEFAULT_AVATAR = "../img/qq_small.jpg";

    @Resource(name = "userService")
    private UserService us;

    @Resource(name = "relationService")
    private RelationService rs;
    @Resource(name = "roleService")
    private RoleService ros;

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



    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }


    /**
     * shiro 权限控制
     * @param user
     * , produces = "application/json;charset=utf-8"
     * @return
     */
    @RequestMapping(value = "/home")
    public String home(Model m, User user){
//        //获取当前用户名
//        Subject currentUser = SecurityUtils.getSubject();
//        String number = (String) currentUser.getPrincipal();
//        if (!currentUser.isAuthenticated()) {
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
//        }else {
//            return "/user/home";
//        }


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
        user.setAvatar(DEFAULT_AVATAR);

        Role role = new Role();
        role.setName("student");
        role.setUser(user);
        ros.insert(role);

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

    /**
     * 提交修改
     */
    @RequestMapping(value = "/user/forgetPassword", produces = "application/json;charset=utf-8")
    public String forgetPassword(Model m, @RequestParam("number") String number){
        User user = us.selectByNumber(number);
        user.getEmail();
        //todo
        return null;
    }

    /**
     * 到修改密码界面
     */
    @RequestMapping(value = "/user/toChangePassword", produces = "application/json;charset=utf-8")
    public String toChangePassword(){
        //获取当前用户名
        Subject currentUser = SecurityUtils.getSubject();
        String number = (String) currentUser.getPrincipal();
        User user = us.selectByNumber(number);
        String code = ToolUtil.getRandomNumberString(4);
        user.setCode(code);
        us.updateByNumber(user);

        Boolean isSuccess = MailUtil.sendMail("修改密码", code,user.getEmail(),user.getName());
        if (!isSuccess){
            return "fail";
        }
        return "/user/changePassword";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/user/doChangePassword")
    public String doChangePassword(@RequestParam("password1") String password1, @RequestParam("password2") String password2, @RequestParam("code") String code){
        // 修改密码后要重新登录
        // todo
        //获取当前用户名
        Subject currentUser = SecurityUtils.getSubject();
        String number = (String) currentUser.getPrincipal();
        User user = us.selectByNumber(number);
        if (password1!=null&&!"".equals(password1)&&password1.equals(password2)&&code!=null&&code.equals(user.getCode())){
            Md5Hash md5Hash = new Md5Hash(password1, number);//a81082604404c078e80f8bf501133abe
            user.setPassword(md5Hash.toString());
            us.updatePasswordByNumber(user);
        }else if (password1==null||"".equals(password1)||!password1.equals(password2)){
            return "user/passwordDiff";
        }else if(code==null||!code.equals(user.getCode())){
            return "user/codeError";
        }

        return "redirect:/";
    }


    /**
     * 退出
     */
    @RequestMapping(value = "/user/logout", produces = "application/json;charset=utf-8")
    public String logout(Model m, User user){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        System.out.println(currentUser.isAuthenticated());
        return "redirect:/";
    }
}
