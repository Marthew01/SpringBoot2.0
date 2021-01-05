package com.fapiao.redis.mapper;

import com.fapiao.redis.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.mapper
 * @date 2021/1/4/004 15:57
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

}
