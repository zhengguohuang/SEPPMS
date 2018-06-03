package cn.edu.hyit.seppms.dao.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupInfoDaoImplTest {

    @Test
    public void test(){
        GroupInfoDaoImpl gid = new GroupInfoDaoImpl();
        int i = gid.selectGroupIdByLeaderId(6);
        System.out.println(i);
    }

}