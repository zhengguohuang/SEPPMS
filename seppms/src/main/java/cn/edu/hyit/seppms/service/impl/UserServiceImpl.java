package cn.edu.hyit.seppms.service.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.Item;
import cn.edu.hyit.seppms.domain.Order;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource(name = "itemDao")
    private BaseDao<Item> itemDao;

    @Resource(name = "userDao")
    private UserDaoImpl dao;

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }

    /**
     * 长事务测试
     */
    public void longTx() {
        // 插入item
        Item i = new Item();
        i.setItemName("ttt");
        Order o = new Order();
        o.setId(2);
        i.setOrder(o);
        itemDao.insert(i);

        // 删除抛出异常
        this.delete(1);
    }

    public void save(User u) {
        if (u.getId() != null){
            this.update(u);
        }
        else {
            this.insert(u);
        }
    }

    public User selectByNumber(String number) {
        return dao.selectByNumber(number);
    }

    public User getUserByNumber(String number) {
        return dao.getUserByNumber(number);
    }




}
