package com.fapiao.layui.mapper;

import com.fapiao.layui.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.dao
 * @date 2021/1/6/006 16:33
 */
@Repository
public interface UserMapper {

    public User findById(long id);

    public User findByUsername(String username);

    public List<User> findAll();
}
