package cn.edu.hyit.seppms.service.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Belong;
import cn.edu.hyit.seppms.service.BelongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("belongService")
public class BelongServiceImpl extends BaseServiceImpl<Belong> implements BelongService {
    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "belongDao")
    public void setDao(BaseDao<Belong> dao) {
        super.setDao(dao);
    }

    @Resource(name = "belongDao")
    private BaseDao<Belong> belongDao;
}
