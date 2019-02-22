package com.wenyb.springbootcache.service;

import com.wenyb.springbootcache.bean.Employee;
import com.wenyb.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wenyabing
 * @Date 2019/2/20 21:20
 */
@CacheConfig(cacheNames = "emp", cacheManager = "employeeCacheManager")
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    @Cacheable(/*cacheNames = "emp"*/)
    public Employee getEmployeeById(Integer id) {
        System.out.println("获取第" + id + "号员工");
        return employeeMapper.getEmployeeById(id);
    }

    @CachePut(/*cacheNames = "emp",*/ key = "#employee.id")
    public Employee updateEmployee(Employee employee) {
        System.out.println("updateEmployee: " + employee);
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    @CacheEvict(/*cacheNames = "emp",*/ key = "#id")
    public void deleteEmployee(Integer id) {
        System.out.println("删除" + id + "号员工");
//        employeeMapper.deleteEmployee(id);
    }

    public List<Employee> employees() {
        return employeeMapper.employees();
    }
}
