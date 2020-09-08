package com.jc.dao;

import com.jc.entity.EmpDep;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface EmpDepDao {

    /**
     * 查询所有员信息，根据需要延迟加载其部门信息
     * @return
     */
    @Select("select * from employee")
    @Results(id="empDepMap",value = {
            @Result(property = "uid",column = "uid"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "dep_id",column = "dep_id"),
            @Result(property = "department",column = "dep_id",one = @One(select = "com.jc.dao.DepartmentDao.findById",fetchType = FetchType.LAZY))
    })
   List<EmpDep> findAll();
}
