package com.fapiao.redis.service;

import com.fapiao.redis.entity.Department;
import com.fapiao.redis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.service
 * @date 2021/1/4/004 16:02
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = { "dept" }/*, condition = "#a0>1", unless = "#a0==2"*/)
    public Department getDept(Integer id) {
        System.out.println("查询"+ id  +"号部门。" );
        Department dept = this.departmentMapper.getDeptById(id);
        return dept;
    }
}
