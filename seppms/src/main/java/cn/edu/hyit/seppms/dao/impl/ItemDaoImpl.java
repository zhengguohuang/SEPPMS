package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Item;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemDao")
public class ItemDaoImpl extends SqlSessionDaoSupport implements BaseDao<Item> {
    public void insert(Item item) {
        getSqlSession().insert("items.insert", item);
    }

    public void update(Item item) {
        getSqlSession().update("items.update", item);
    }

    public void delete(Integer id) {
        getSqlSession().delete("items.delete", id);
    }

    public Item selectOne(Integer id) {
        return getSqlSession().selectOne("items.selectOne", id);
    }

    public List<Item> selectAll() {
        return getSqlSession().selectList("items.selectAll");
    }

    public List<Item> selectPage(int offset, int len) {
        //TODO
        return null;
    }

    public int selectCount() {
        //TODO
        return 0;
    }
}
