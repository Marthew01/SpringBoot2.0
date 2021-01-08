package com.fapiao.layui.controller;

import com.fapiao.layui.config.shiro.PasswordHelper;
import com.fapiao.layui.model.User;
import com.fapiao.layui.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 管理员
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.controller
 * @date 2021/1/7/007 16:32
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHelper passwordHelper;

    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        passwordHelper.encryptPassword(user);
        userService.save(user);
        log.info("用户: {} 注册成功",username);
        model.addAttribute("msg","用户: "+username+" 注册成功");
        return "/common/success";
    }

    @GetMapping("/userList")
    public List<User> userList(@RequestParam(value ="page",required=false) Integer page,
                         @RequestParam(required=false) Integer size) {
//        PageInfo<User> pageInfo = new PageInfo<>(userService.getUserList());
        PageHelper.offsetPage(page, size);
        PageInfo<User> pageInfo = PageInfo.of(userService.getUserList());
        List<User> list = pageInfo.getList();
//        PageInfo<User> pageInfo = PageHelper.startPage(page, limit).doSelectPageInfo(() -> userService.getUserList());
        System.out.println("总数量"+pageInfo.getTotal());
         System.out.println("当前页查询记录"+pageInfo.getList().size());
         System.out.println("当前页码"+pageInfo.getPageNum());
         System.out.println("每页显示数量"+pageInfo.getPageSize());
         System.out.println("总页"+pageInfo.getPages());
        return list;
    }


}
