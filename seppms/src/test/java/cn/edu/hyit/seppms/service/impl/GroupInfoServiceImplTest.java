package cn.edu.hyit.seppms.service.impl;

import cn.edu.hyit.seppms.domain.GroupInfo;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.GroupInfoService;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;


public class GroupInfoServiceImplTest {
    @Resource(name = "groupInfoService")
    private GroupInfoService gs;
    @Test
    public void selectAll(){
        List<GroupInfo> groupInfos = gs.selectAll();
        for (GroupInfo groupInfo : groupInfos) {
            System.out.println(groupInfo.getId() +"\t" + groupInfo.getLeader().getNumber() +"\t"+ groupInfo.getTeacher().getNumber() + "\t" + groupInfo.getName() );
            List<User> members = groupInfo.getMembers();
            for (User member : members) {
                System.out.println("--------------" + member.getNumber() + "\t" + member.getName());
            }
        }
    }

}