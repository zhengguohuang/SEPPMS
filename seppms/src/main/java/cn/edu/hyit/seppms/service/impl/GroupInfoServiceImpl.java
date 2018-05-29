package cn.edu.hyit.seppms.service.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.GroupInfo;
import cn.edu.hyit.seppms.service.GroupInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("groupInfoService")
public class GroupInfoServiceImpl extends BaseServiceImpl<GroupInfo> implements GroupInfoService {
    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "groupInfoDao")
    public void setDao(BaseDao<GroupInfo> dao) {
        super.setDao(dao);
    }

    @Resource(name = "groupInfoDao")
    private BaseDao<GroupInfo> groupInfoDao;


}
