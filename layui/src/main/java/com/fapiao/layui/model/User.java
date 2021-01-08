package com.fapiao.layui.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhang-rongyao
 * @version V1.0
 * @Package com.fapiao.layui.model
 * @date 2020/12/22/022
 */
@Entity
@Table(name = "user_t")
public class User implements Serializable {
    private static final long serialVersionUID = -7927203001962811150L;
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String salt;
    private long experience;//积分
    private String sex;
    private String city;
    private String classify;//职业
    private long wealth;//财富


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
            @JoinColumn(name = "rid") })
    private List<SysRole> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getCredentialsSalt() {
        return username + salt + salt;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public long getWealth() {
        return wealth;
    }

    public void setWealth(long wealth) {
        this.wealth = wealth;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(long id, String username, String password, String salt, long experience, String sex, String city, String classify, long wealth, List<SysRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.experience = experience;
        this.sex = sex;
        this.city = city;
        this.classify = classify;
        this.wealth = wealth;
        this.roles = roles;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }

}