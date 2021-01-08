package com.fapiao.layui.service;

import com.fapiao.layui.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.service
 * @date 2021/1/6/006 16:32
 */

public interface UserService {

    public User findUserById(long id);

    public User findUserByName(String name);

    public List<User> getUserList();

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

}
