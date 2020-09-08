package com.jc.dao;

import com.jc.entity.Department;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface DepartmentDao {
    /**
     * 根据部门id查询部门信息
     * @return
     */
    @Select("select * from department where did = #{id}")
    @Results(id="departmentMap",value = {
            @Result(id=true,property = "did",column = "did"),
            @Result(property = "dep_name", column = "dep_name"),
            @Result(property = "location",column = "location")
    })
    Department findById(Integer id);
}
