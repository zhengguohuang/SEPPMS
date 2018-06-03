package cn.edu.hyit.seppms.service;

import cn.edu.hyit.seppms.domain.GroupInfo;
import cn.edu.hyit.seppms.service.impl.GroupInfoServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupInfoServiceTest {

    @Test
    public void test(){
        GroupInfoService gs= new GroupInfoServiceImpl();
        int groupInfo = gs.selectGroupIdByLeaderId(new Integer(6));
        System.out.println(groupInfo);
    }

}