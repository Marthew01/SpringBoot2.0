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
@Table(name = "permission_t")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 6991235513096205138L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToMany
    @JoinTable(name = "role_permission_t", joinColumns = { @JoinColumn(name = "pid") }, inverseJoinColumns = {
            @JoinColumn(name = "rid") })
    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
