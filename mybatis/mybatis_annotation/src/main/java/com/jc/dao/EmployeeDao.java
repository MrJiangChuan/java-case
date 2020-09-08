package com.jc.dao;

import com.jc.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

//配置二级缓存
@CacheNamespace(blocking = true)
public interface EmployeeDao {

    /**
     * 查询所有员工信息
     * @return
     */
    @Select("select * from employee")
    @Results(id="employeeMap",value = {
            @Result(id=true, property = "uid", column = "uid"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "dep_id", column = "dep_id")
    })
    List<Employee> findAll();

    /**
     * 根据员工id查询员工信息
     * @return
     */
    @Select("select * from employee where uid = #{id}")
    @ResultMap("employeeMap")
    Employee findById(Integer id);

    /**
     * 根据部门id查询员工信息
     * @return
     */
    @Select("select * from employee where dep_id = #{id}")
    @ResultMap("employeeMap")
    Employee findByDepId(Integer id);

    /**
     * 模糊查询员工信息
     * @param employee
     * @return
     */
    @SelectProvider(type=EmployeeDynamicSqlProvide.class, method="select")
    @ResultMap("employeeMap")
    List<Employee> findFuzzy(Employee employee);

    /**
     * 查询员工总数
     * @return
     */
    @Select("select count(*) from employee")
    Integer findTotal();

    /**
     * 增加员工
     * @return
     */
    @Insert("insert into employee(name,age,sex,dep_id) values(#{name},#{age},#{sex},#{dep_id})")
    Integer insert(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     */
    @Update("update employee set name=#{name}, age=#{age}, sex=#{sex}, dep_id=#{dep_id} where uid=#{uid}")
    Integer update(Employee employee);

    /**
     * 删除某个员工
     * @param id
     * @return
     */
    @Delete("delete from employee where uid=#{id}")
    Integer delete(Integer id);


}
