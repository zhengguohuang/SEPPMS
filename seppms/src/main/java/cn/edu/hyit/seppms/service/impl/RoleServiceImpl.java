package cn.edu.hyit.seppms.service.impl;

import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.dao.impl.RoleDaoImpl;
import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.Role;
import cn.edu.hyit.seppms.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Resource(name = "roleDao")
    private RoleDaoImpl dao;

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "roleDao")
    public void setDao(BaseDao<Role> dao) {
        super.setDao(dao);
    }


    public List<String> getRolesByNumber(String number) {
        return dao.getRolesByNumber(number);
    }
}
