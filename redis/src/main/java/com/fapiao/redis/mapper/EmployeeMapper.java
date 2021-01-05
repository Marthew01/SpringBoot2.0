package com.fapiao.redis.mapper;

import com.fapiao.redis.entity.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.mapper
 * @date 2021/1/4/004 15:59
 */
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} where id=#{id} ")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmp(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id}values (#{lastName},#{email},#{gender},#{dId}  ))")
    public void insertEmploree(Employee employee);

    @Select("select * from emplyee where lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
