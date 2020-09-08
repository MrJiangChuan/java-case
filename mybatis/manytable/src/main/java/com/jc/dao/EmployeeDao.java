package com.jc.dao;

import com.jc.entity.*;

import java.util.List;

public interface EmployeeDao {

    /**
     * 查询所有员工
     * @return
     */
    List<Employee> findEmployeeAll();

    /**
     * 根据员工id查询员工信息
     * @param id
     * @return
     */
    Employee findEmployeeById(Integer id);

    /**
     * 模糊查询员工信息
     * @return
     */
    List<Employee> findFuzzyEmployee(Employee employee);

    /**
     * 模糊查询员工信息，根据id集合
     * @return
     */
    List<Employee> findEmployeeByIds(QueryVo ids);

    /**
     * 根据部门dep_id查询员工信息
     * @param id
     * @return
     */
    Employee findEmployeeByDepId(Integer id);

    /**
     * 查询所有部门
     * @return
     */
    List<Department> findDepartmentAll();

    /**
     * 根据部门id查询部门信息
     * @param id
     * @return
     */
    Department findDepartmentById(Integer id);

    /**
     * 查询所有员工及其所属部门
     * @return
     */
    List<EmployeeDep> findEmployeeDep();

    /**
     * 查询所有部门及其内员工
     * @return
     */
    List<DepartmentEmp> findDepartmentEmp();
}
