package com.wenyb.springbootcache.config;

import com.wenyb.springbootcache.bean.Department;
import com.wenyb.springbootcache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;

/**
 * @Author wenyabing
 * @Date 2019/2/21 15:00
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        //修改序列化器为Jackson2JsonRedisSerializer
        RedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Employee.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }

    /**
     * 自定义cacheManager
     */
    @Primary
    @Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }


    @Bean
    public RedisTemplate<Object, Department> departmentRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Department.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }

    @Bean
    public RedisCacheManager departmentCacheManager(RedisTemplate<Object, Department> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
