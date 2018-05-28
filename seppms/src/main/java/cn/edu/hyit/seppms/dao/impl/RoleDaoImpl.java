package cn.edu.hyit.seppms.dao.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Role;
import cn.edu.hyit.seppms.domain.User;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends SqlSessionDaoSupport implements BaseDao<Role> {
    public void insert(Role role) {

    }

    public void update(Role role) {

    }

    public void delete(Integer id) {

    }

    public Role selectOne(Integer id) {
        return null;
    }

    public List<Role> selectAll() {
        return null;
    }

    public List<Role> selectPage(int offset, int len) {
        return null;
    }

    public int selectCount() {
        return 0;
    }


    public List<String> getRolesByNumber(String number) {
        List<String> list = getSqlSession().selectList("sys_role.getRolesByNumber", number);
        //判空
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        for (String s : list) {
            System.out.println(s);
        }
        return list;
    }
}
