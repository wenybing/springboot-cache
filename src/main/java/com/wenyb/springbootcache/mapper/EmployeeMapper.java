package com.wenyb.springbootcache.mapper;

import com.wenyb.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author wenyabing
 * @Date 2019/2/20 20:58
 */
@Mapper
public interface EmployeeMapper {
    @Insert("insert into employee(id,lastName,email,gender,d_id)values(#{id},#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);

    @Select("select * from employee where id=#{id}")
    public Employee getEmployeeById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender} where id = #{id}")
    public void updateEmployee(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmployee(Integer id);

    @Select("select * from employee")
    public List<Employee> employees();
}
