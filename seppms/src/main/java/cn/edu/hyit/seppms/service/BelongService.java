package cn.edu.hyit.seppms.service;

import cn.edu.hyit.seppms.domain.Belong;

public interface BelongService extends BaseService<Belong> {
    public int getGroupCountByUserId(Integer userId);
}
