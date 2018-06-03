package cn.edu.hyit.seppms.service;

import cn.edu.hyit.seppms.domain.GroupInfo;

public interface GroupInfoService extends BaseService<GroupInfo>{
    public GroupInfo selectByLeaderId(Integer id);

    public int selectGroupIdByLeaderId(Integer id);

}
