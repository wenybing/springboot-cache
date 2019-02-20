package com.wenyb.springbootcache.controller;

import com.wenyb.springbootcache.bean.Employee;
import com.wenyb.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wenyabing
 * @Date 2019/2/20 21:24
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public Employee getEmployeeById(@RequestParam("id") Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PutMapping("/employee/update")
    public Employee updateEmployee(Employee employee) {
        Employee employee1 = employeeService.updateEmployee(employee);
        return employee1;
    }

    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "success";
    }
}
