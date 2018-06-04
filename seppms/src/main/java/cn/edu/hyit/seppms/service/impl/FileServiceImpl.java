package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.FileDaoImpl;
import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.File;
import cn.edu.hyit.seppms.domain.Item;
import cn.edu.hyit.seppms.domain.Order;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.FileService;
import cn.edu.hyit.seppms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("fileService")
public class FileServiceImpl extends BaseServiceImpl<File> implements FileService {
    @Resource(name = "fileDao")
    private FileDaoImpl dao;

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "fileDao")
    public void setDao(BaseDao<File> dao) {
        super.setDao(dao);
    }

}
