package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource(name = "userService")
    private UserService us;

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
     * 用户登录
     * @param m
     * @return
     */
    @RequestMapping("/user/login")
    public String login(Model m){
        return "user/login";
    }

    /**
     * vertify登录
     */
    @RequestMapping(value = "/user/vertify", method = RequestMethod.POST)
    public String vertify(Model m, @RequestParam("number") String number, @RequestParam("password") String password){
        User user = us.selectByNumber(number);
        m.addAttribute("user", user);
        if (user != null){
            if (password != null && !password.equals("") && password.equals(user.getPassword())){
                return "user/userHome";
            }
        }
        else {
            return "/user/login";
        }
        return "/user/login";
    }

    /**
     * shiro 权限控制
     * @param user
     * @return
     */
    @RequestMapping(value = "/subLogin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String subLogin(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNumber(), user.getPassword());
        try {
            subject.login(token);
        }
        catch (Exception e){
            return e.getMessage();
        }
        if (subject.hasRole("admin")){
            return "有admin权限";
        }
        return "无admin权限";
    }
}
