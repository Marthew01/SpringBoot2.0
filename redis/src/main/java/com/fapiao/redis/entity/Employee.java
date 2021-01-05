package com.fapiao.redis.entity;

import java.io.Serializable;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.entity
 * @date 2021/1/4/004 15:56
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = -755110953376963946L;
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
    public Employee() {
        super();
    }
    public Employee(Integer id, String lastName, String email, Integer gender, Integer dId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dId = dId;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + this.id +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", gender=" + this.gender +
                ", dId=" + this.dId +
                '}';
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getGender() {
        return this.gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public Integer getdId() {
        return this.dId;
    }
    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
