package com.fapiao.layui;

import com.fapiao.layui.mapper.UserMapper;
import com.fapiao.layui.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class LayuiApplicationTests {

    private final Logger log = LoggerFactory.getLogger(LayuiApplicationTests.class);
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {

        User user= userMapper.findByUsername("zhang");
        log.info("result: {}",user);

    }

}
