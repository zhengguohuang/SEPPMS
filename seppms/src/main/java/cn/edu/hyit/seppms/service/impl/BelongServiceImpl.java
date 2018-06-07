package cn.edu.hyit.seppms.service.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.BelongDaoImpl;
import cn.edu.hyit.seppms.domain.Belong;
import cn.edu.hyit.seppms.service.BelongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("belongService")
public class BelongServiceImpl extends BaseServiceImpl<Belong> implements BelongService {
    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "belongDao")
    public void setDao(BaseDao<Belong> dao) {
        super.setDao(dao);
    }

    @Resource(name = "belongDao")
    private BelongDaoImpl dao;

    @Override
    public int getGroupCountByUserId(Integer userId) {
        return dao.getGroupCountByUserId(userId);
    }

    @Override
    public List<Belong> selectMemberByLeaderId(Integer id) {
        return dao.selectMemberByLeaderId(id);
    }

    @Override
    public List<Belong> selectAllStudent() {
        return dao.selectAllStudent();
    }
}
