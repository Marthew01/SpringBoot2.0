package com.fapiao.layui.jpa;

import com.fapiao.layui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.dao
 * @date 2021/1/6/006 16:33
 */

public interface UserRepository extends JpaRepository <User, Long> {

    /**
     * 查询user
     * @param id
     * @return
     */
    public User findById(long id);

    /**
     * 查询用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 查询列表
     * @return
     */
    @Override
    List<User> findAll();

    /**
     * 保存
     * @param user
     * @return
     */
    @Override
    public User save(User user);
}
