package cn.edu.hyit.seppms.web.controller;

import cn.edu.hyit.seppms.domain.MemberUpFile;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.util.TimeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RequestMapping("file")
@Controller
public class FileController {
    /**
     * 文件上传功能
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request, @RequestParam("leaderTaskId") int leaderTaskId) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("file");
//        System.out.println(path);
        String fileName = file.getOriginalFilename();
//        System.out.println(fileName);
        File dir = new File(path,fileName);
//        System.out.println(dir);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);

        // 文件名路径等信息插入file表
        cn.edu.hyit.seppms.domain.File file1 = new cn.edu.hyit.seppms.domain.File();
        file1.setCreateTime(TimeUtil.getCurrentSQLTime());
        file1.setFileName(fileName);
        file1.setUrl("../file/" + fileName);
//        fs.insert(file1);
//        // 文件id,leadertaskid插入memberupfile表
//        // 通过文件名查询文件id
//        cn.edu.hyit.seppms.domain.File file2 = fs.selectOneByFileName(fileName);
//        Integer fileId = file2.getId();
//        //获取当前用户名
//        Subject subject = SecurityUtils.getSubject();
//        String number = (String) subject.getPrincipal();
//        User user = us.selectByNumber(number);
//        MemberUpFile memberUpFile = new MemberUpFile();
//        memberUpFile.setFileId(fileId);
//        memberUpFile.setLeaderTaskId(leaderTaskId);
//        mufs.insert(memberUpFile);

        return "ok!";
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("file")+"/5.txt";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }
}