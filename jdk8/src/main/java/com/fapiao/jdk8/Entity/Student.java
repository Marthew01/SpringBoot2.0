package com.fapiao.jdk8.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.jdk8.Entity
 * @date 2020/12/31/031 14:08
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
        /** 学号 */
        private long id;
        private String name;
        private int age;
        /** 年级 */
        private int grade;
        /** 专业 */
        private String major;
        /** 学校 */
        private String school;
        // 省略getter和setter
}
