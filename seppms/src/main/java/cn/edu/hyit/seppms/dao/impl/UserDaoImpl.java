package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements BaseDao<User> {

    public void insert(User user) {
        getSqlSession().insert("users.insert", user);
    }

    public void update(User user) {
        getSqlSession().update("users.update", user);
    }

    public void delete(Integer id) {
        getSqlSession().delete("users.delete", id);
    }

    public User selectOne(Integer id) {
        return getSqlSession().selectOne("sys_user.selectOne", id);
    }

    public List<User> selectAll() {
        return getSqlSession().selectList("sys_user.selectAll");
    }

    /**
     * 分页查询
     * @param offset
     * @param len
     * @return
     */
    public List<User> selectPage(int offset, int len) {
        return getSqlSession().selectList("users.selectPage", new RowBounds(offset, len));
    }

    public int selectCount() {
        return getSqlSession().selectOne("users.selectCount");
    }

    public User selectByNumber(String number){
        return getSqlSession().selectOne("sys_user.selectByNumber", number);
    }

    public User getUserByNumber(String number) {
        List<User> list = getSqlSession().selectList("sys_user.getUserByNumber", number);
        //判空
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        System.out.println(list.get(0).getPassword());
        return list.get(0);
    }


}
