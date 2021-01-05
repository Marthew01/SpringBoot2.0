package com.fapiao.redis.controller;

import com.fapiao.redis.entity.Employee;
import com.fapiao.redis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.controller
 * @date 2021/1/4/004 16:05
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("deleteemp")
    public String deleteEmp(Integer id) {
        this.employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        Employee emp = this.employeeService.getEmp(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        Employee emp = this.employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable(value = "lastName") String lastName)  {
        return this.employeeService.getEmpByLastName(lastName);
    }
}
