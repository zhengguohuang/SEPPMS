package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Order;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends SqlSessionDaoSupport implements BaseDao<Order> {
    public void insert(Order order) {
        getSqlSession().insert("orders.insert", order);
    }

    public void update(Order order) {
        getSqlSession().update("orders.update", order);
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
