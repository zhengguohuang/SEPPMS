package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.RelationDaoImpl;
import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.Item;
import cn.edu.hyit.seppms.domain.Order;
import cn.edu.hyit.seppms.domain.Relation;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.RelationService;
import cn.edu.hyit.seppms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("relationService")
public class RelationServiceImpl extends BaseServiceImpl<Relation> implements RelationService {


    @Resource(name = "relationDao")
    private RelationDaoImpl dao;

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "relationDao")
    public void setDao(BaseDao<Relation> dao) {
        super.setDao(dao);
    }


    public List<Relation> selectAllByNumber(String number) {
        return dao.selectAllByNumber(number);
    }
}
