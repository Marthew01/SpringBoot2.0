package com.fapiao.redis.entity;

import java.io.Serializable;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.dao
 * @date 2021/1/4/004 15:56
 */
public class Department implements Serializable {

    private static final long serialVersionUID = 8879794768657986021L;
    private Integer id;
    private String departmentName;

    public Department() {
        super();
    }
    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + this.id +
                ", departmentName='" + this.departmentName + '\'' +
                '}';
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
