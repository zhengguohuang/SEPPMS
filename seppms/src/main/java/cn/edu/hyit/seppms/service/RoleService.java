package cn.edu.hyit.seppms.service;

import cn.edu.hyit.seppms.domain.Role;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    List<String> getRolesByNumber(String number);
}
