package com.fapiao.jdk8.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhang-rongyao
 * @version V1.0
 * @Package com.fapiao.jdk8.Entity
 * @date 2020/12/29/029
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private  Integer age;
}
