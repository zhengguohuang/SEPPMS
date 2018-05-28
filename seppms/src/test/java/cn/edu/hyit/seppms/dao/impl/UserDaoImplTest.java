package cn.edu.hyit.seppms.dao.impl;

import cn.edu.hyit.seppms.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoImplTest {

    @Test
    public void selectAll(){

    }

    @Test
    public void selectOne() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User u = (User) sqlSession.selectOne("sys_user.selectOne", 1);
        System.out.println(u.getName());

    }

}