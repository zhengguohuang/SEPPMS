package cn.edu.hyit.seppms.service;

import cn.edu.hyit.seppms.domain.Belong;

import java.util.List;

public interface BelongService extends BaseService<Belong> {
    public int getGroupCountByUserId(Integer userId);

    List<Belong> selectMemberByLeaderId(Integer id);

    List<Belong> selectAllStudent();

}
