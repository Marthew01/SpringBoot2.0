package com.fapiao.redis.service;

import com.fapiao.redis.entity.Employee;
import com.fapiao.redis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.redis.service
 * @date 2021/1/4/004 16:03
 */

@CacheConfig(cacheNames = "emps") //抽取缓存的公共配置  虽然没用到哈哈
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * @CacheEvict : 缓存清除
     * key : 指定要清除的数据
     * allEntries = true : 指定要清除所有的数据
     * beforeInvocation = false : 缓存的清除是否再方法之前执行
     *          默认代表缓存清除操作是在方法执行后执行 ； 如果出现异常缓存就不会清除
     * beforeInvocation = true : 代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     *
     * @param id
     */
    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp : "+id);
//        this.employeeMapper.deleteEmp(id);
    }

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中取，不用调用方法
     *
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作再Cache组件中，每一个缓存组件有自己唯一一个名字
     * 几个属性：
     *      cacheNames/value：指定缓存组件的名字；
     *      key:缓存数据使用的key，可以用它来指定。默认是使用方法的参数的值  1-方法的返回值
     *              编写SpEL;   #id；参数id的值   #a0  #p0  #root.args[0]
     *      keyGenerator:key的生成器；可以自己指定key的生成器的组件id
     *              key/keyGenerator:二选一使用
     *      cacheManager:指定缓存管理器；或者cacheResolver指定获取解析器  它俩也是二选一使用
     *      condition:指定符合条件的情况下才缓存
     *                          ，condition = "#id>0"
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *                  unless = "#result == null"
     *      sync:是否使用异步模式
     *
     *
     * 原理：
     *      1、自动配置类 CacheAutoConfiguration
     *      2、缓存的配置
     *
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = { "emp" }/*, condition = "#a0>1", unless = "#a0==2"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询"+ id  +"号员工。" );
        Employee emp = this.employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @cachePut : 既调用方法，又更新缓存数据；
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     *  1、先调用目标方法
     *  2、将目标方法的结果缓存起来
     * @param employee
     * @return
     *
     *
     * 测试步骤：
     *  1、查询1号员工：查询到的结果放在缓存中；
     *          key:1   value: lastName:张三
     *  2、以后查询还是之前的结果
     *  3、更新1号员工：【lastName:zhangsan;gender:0】
     *          将方法的返回值也放进缓存了；
     *          key:传入的employee对象   值：返回的employee对象；
     *  4、查询1号员工？
     *          应该是更新后的员工；
     *                  key = "#employee.id":使用传入的参数的员工id；
     *                  key = "#result.id":使用返回的id
     *                      @Cacheable的key是不能用#result
     *          为什么是没更新之前的？【1号员工没有再缓存中更新】
     */
    @CachePut(value = "emp" ,key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp:"+employee);
        this.employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @Cacheing : 定义复杂的缓存规则
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(value="emp", key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email"),
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return this.employeeMapper.getEmpByLastName(lastName);
    }
}
