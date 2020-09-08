package com.jc.dao;

import com.jc.entity.DepEmp;
import com.jc.entity.Department;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DepEmpDao {

    /**
     * 查询所有部门，及其员工，延迟加载
     * @return
     */
    @Select("select * from department")
    @Results(id="depEmpMap",value = {
            @Result(id = true,property = "did",column = "did"),
            @Result(property = "dep_name",column = "dep_name"),
            @Result(property = "location",column = "location"),
            @Result(property = "employees",column = "did", many = @Many(select = "com.jc.dao.EmployeeDao.findByDepId",fetchType = FetchType.LAZY))
    })
    List<DepEmp> findAll();
}
