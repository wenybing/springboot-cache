package com.wenyb.springbootcache;

import com.wenyb.springbootcache.bean.Employee;
import com.wenyb.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@MapperScan("com.wenyb.springbootcache.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

    /**
     * 测试redis缓存
     */
    @Test
    public void testRedisTemplate() {
        Employee employee = employeeMapper.getEmployeeById(1);
//        redisTemplate.opsForValue().set("emp", employee);
        empRedisTemplate.opsForValue().set("emp", employee);
    }

    /**
     * 测试StringRedisTemplate
     */
    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("str1", "hello");
        stringRedisTemplate.opsForValue().append("str1", " world!");
    }
}
