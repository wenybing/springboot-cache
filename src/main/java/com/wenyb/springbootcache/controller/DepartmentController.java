package com.wenyb.springbootcache.controller;

import com.wenyb.springbootcache.bean.Department;
import com.wenyb.springbootcache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wenyabing
 * @Date 2019/2/21 15:56
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id) {
        Department department = departmentService.getDepartmentById(id);
        return department;
    }


}
