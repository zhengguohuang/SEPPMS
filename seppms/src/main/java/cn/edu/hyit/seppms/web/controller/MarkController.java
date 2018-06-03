package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.Mark;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.MarkService;
import cn.edu.hyit.seppms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class MarkController {

    @Resource(name = "userService")
    private UserService us;

    @Resource(name = "markService")
    private MarkService ms;


    @RequestMapping("/info/graphMark")
    public String findAll(Model m){
        //获取当前用户名
        Subject currentUser = SecurityUtils.getSubject();
        String number = (String) currentUser.getPrincipal();
        User user = us.selectByNumber(number);
        Mark myMark = ms.selectOneByStudentId(user.getId());

        // 查询班级平均成绩
        int classDaily = ms.getDailyAvg();
        int classReply = ms.getReplyAvg();
        int clssDocument = ms.getDocumentAvg();


        m.addAttribute("myMark", myMark);
        m.addAttribute("classDaily", classDaily);
        m.addAttribute("classReply", classReply);
        m.addAttribute("clssDocument", clssDocument);

        return "/info/graphMark";
    }
}
