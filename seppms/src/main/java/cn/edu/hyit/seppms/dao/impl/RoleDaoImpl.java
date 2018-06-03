package cn.edu.hyit.seppms.dao.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.Role;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends SqlSessionDaoSupport implements BaseDao<Role> {
    public Boolean insert(Role role) {
        int rows = getSqlSession().insert("sys_role.insert", role);
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean update(Role role) {
        int result = getSqlSession().update("sys_role.update", role);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
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

    public List<Role> selectAllByRoleName(String roleName) {
        List<Role> list = getSqlSession().selectList("sys_role.selectAllByRoleName", roleName);
        //判空
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list;
    }
}
