package com.fapiao.layui.service.impl;

import com.fapiao.layui.mapper.UserMapper;
import com.fapiao.layui.jpa.UserRepository;
import com.fapiao.layui.model.User;
import com.fapiao.layui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.service.impl
 * @date 2021/1/6/006 16:33
 */
@Service
public class UserServiceImpl implements UserService {
    //jpa

    @Autowired
    UserRepository userRepository;
    //mybatis

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(long id) {

    }
}
