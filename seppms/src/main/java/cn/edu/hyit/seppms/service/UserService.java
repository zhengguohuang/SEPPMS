package cn.edu.hyit.seppms.service;


import cn.edu.hyit.seppms.domain.User;

public interface UserService extends BaseService<User> {
    // User的共有方法放在这里
    public void longTx();

    void save(User u);
    public User selectByNumber(String number);
    public User getUserByNumber(String number);
}
