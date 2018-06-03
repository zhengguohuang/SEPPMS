package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Order;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends SqlSessionDaoSupport implements BaseDao<Order> {
    public Boolean insert(Order order) {
        int rows = getSqlSession().insert("orders.insert", order);
        if(rows > 0){
            return true;
        }
        return false;
    }

    public Boolean update(Order order) {
        int rows = getSqlSession().update("orders.update", order);
        if(rows > 0){
            return true;
        }
        return false;
    }

    public void delete(Integer id) {
        getSqlSession().delete("orders.delete", id);
    }

    public Order selectOne(Integer id) {
        return getSqlSession().selectOne("orders.selectOne", id);
    }

    public List<Order> selectAll() {
        return getSqlSession().selectList("orders.selectAll");
    }

    public List<Order> selectPage(int offset, int len) {
        //TODO
        return null;
    }

    public int selectCount() {
        //TODO
        return 0;
    }
}
