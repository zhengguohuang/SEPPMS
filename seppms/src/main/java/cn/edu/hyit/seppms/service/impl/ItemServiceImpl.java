package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Item;
import cn.edu.hyit.seppms.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {
    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "itemDao")
    public void setDao(BaseDao<Item> dao) {
        super.setDao(dao);
    }
}
