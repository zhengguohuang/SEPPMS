package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Item;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemDao")
public class ItemDaoImpl extends SqlSessionDaoSupport implements BaseDao<Item> {
    public Boolean insert(Item item) {
        int rows = getSqlSession().insert("items.insert", item);
        if(rows > 0){
            return true;
        }
        return false;
    }

    public Boolean update(Item item) {
        int rows = getSqlSession().update("items.update", item);
        if(rows > 0){
            return true;
        }
        return false;
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
        return null;
    }

    public int selectCount() {
        return 0;
    }
}
