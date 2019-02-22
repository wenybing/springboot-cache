package com.wenyb.springbootcache.mapper;

import com.wenyb.springbootcache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author wenyabing
 * @Date 2019/2/21 15:53
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepartmentById(Integer id);
}
