package com.fapiao.redis.controller;


import com.fapiao.redis.entity.Department;
import com.fapiao.redis.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.controller
 * @date 2021/1/4/004 16:04
 */
@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {

        return this.departmentService.getDept(id);
        
    }
}
