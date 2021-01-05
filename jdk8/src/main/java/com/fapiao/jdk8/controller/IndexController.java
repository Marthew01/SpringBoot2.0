package com.fapiao.jdk8.controller;

import com.fapiao.jdk8.Entity.Student;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhang-rongyao
 * @version V1.0
 * @Package com.fapiao.jdk8.controller
 * @date 2020/12/30/030
 */
@Controller
public class IndexController {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>() {
            {
                this.add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                this.add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                this.add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                this.add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                this.add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                this.add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                this.add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                this.add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                this.add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                this.add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };

       /* List<Student> collect = students.stream().filter(student -> student.getAge() % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);*/

        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

    }


    /**
     * @param
     * @param integer
     * @param str
     * @return java.lang.String
     * @Description TODO
     * @date 2020/12/31/031
     */
    public static String aaa(Integer integer, String str) {


        return "";

    }
}
