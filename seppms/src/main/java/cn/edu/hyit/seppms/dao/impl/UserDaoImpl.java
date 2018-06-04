package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements BaseDao<User> {

    public Boolean insert(User user) {
        int result = getSqlSession().insert("sys_user.insert", user);
        if(result > 0){
            return true;
        }
        return false;
    }

    public Boolean update(User user) {
        int rows = getSqlSession().update("sys_user.update", user);
        return null;
    }

    public void delete(Integer id) {
        getSqlSession().delete("sys_user.delete", id);
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
        return getSqlSession().selectList("sys_user.selectPage", new RowBounds(offset, len));
    }

    public int selectCount() {
        return getSqlSession().selectOne("sys_user.selectCount");
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


    public Boolean updateByNumber(User user) {
        try {
            getSqlSession().update("sys_user.updateByNumber", user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {

        }
        return true;
    }

    public void updatePasswordByNumber(User user) {
        getSqlSession().update("sys_user.updatePasswordByNumber", user);
    }
}
