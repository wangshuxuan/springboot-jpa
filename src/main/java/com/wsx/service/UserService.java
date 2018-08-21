package com.wsx.service;

import com.wsx.repository.UserRepositoty;
import com.wsx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/20 10:04
 * User业务逻辑
 */

@Service
public class UserService {

    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name) {
        User user = userRepositoty.findByUserName(name);
        return user;
    }

    public int save(User user) {
        User user1 = userRepositoty.save(user);
        return (int) user1.getId();
    }

    public boolean deleteById(int id) {
        try {
            userRepositoty.delete((long) id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> listAll() {
        List<User> users = userRepositoty.findAll();
        return users;
    }
}
