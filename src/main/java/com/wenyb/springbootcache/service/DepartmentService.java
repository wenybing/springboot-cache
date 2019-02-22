package com.wenyb.springbootcache.service;

import com.wenyb.springbootcache.bean.Department;
import com.wenyb.springbootcache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @Author wenyabing
 * @Date 2019/2/21 15:54
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisCacheManager departmentCacheManager;

    /**
     * 注解方式添加缓存
     */
    /*@Cacheable(cacheNames = "dept", key = "#id", cacheManager = "departmentCacheManager")
    public Department getDepartmentById(Integer id) {
        Department department = departmentMapper.getDepartmentById(id);
        return department;
    }*/

    /**
     * 编码的方式添加缓存
     */
    public Department getDepartmentById(Integer id) {
        Department department = departmentMapper.getDepartmentById(id);
        //获取某个缓存
        Cache dept = departmentCacheManager.getCache("dept");
        dept.put("dept:" + id, department);
        return department;
    }
}
