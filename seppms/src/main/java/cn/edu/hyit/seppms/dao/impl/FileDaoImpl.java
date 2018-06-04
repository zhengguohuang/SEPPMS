package cn.edu.hyit.seppms.dao.impl;


import cn.edu.hyit.seppms.dao.BaseDao;
import cn.edu.hyit.seppms.domain.File;
import cn.edu.hyit.seppms.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fileDao")
public class FileDaoImpl extends SqlSessionDaoSupport implements BaseDao<File> {

    @Override
    public Boolean insert(File file) {
        return null;
    }

    @Override
    public Boolean update(File file) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public File selectOne(Integer id) {
        return null;
    }

    @Override
    public List<File> selectAll() {
        return null;
    }

    @Override
    public List<File> selectPage(int offset, int len) {
        return null;
    }

    @Override
    public int selectCount() {
        return 0;
    }
}
