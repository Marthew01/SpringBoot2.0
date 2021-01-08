package com.fapiao.layui.controller;

import com.fapiao.layui.model.User;
import com.fapiao.layui.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 登录
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.controller
 * @date 2021/1/6/006 16:15
 */
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param model user
     * @return main.html
     */
    @PostMapping(value = "/dologin")
    public String doLogin(User user, Model model) {
        log.info("LoginController.login()");
        // 根据用户名和密码创建 Token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取 subject 认证主体
        Subject subject = SecurityUtils.getSubject();
        //开始认证，这一步会跳到我们自定义的 Realm 中
        subject.login(token);
        user = userService.findUserByName(user.getUsername());
        model.addAttribute("user", user);
        log.info("user:{}",user);
        return "/common/main";
    }

}
