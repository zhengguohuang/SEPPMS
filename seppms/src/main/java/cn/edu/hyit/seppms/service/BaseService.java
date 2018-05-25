package cn.edu.hyit.seppms.service;

import java.util.List;

public interface BaseService<T> {
    // 所有servive都一样的方法 CRUD
    public void insert(T t);
    public void update(T t);
    public void delete(Integer id);
    public T selectOne(Integer id);
    public List<T> selectAll();

    /**
     * 分页查询
     * @param offset
     * @param len
     * @return
     */
    public List<T> selectPage(int offset, int len);

    public int selectCount();
}
