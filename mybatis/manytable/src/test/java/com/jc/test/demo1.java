package com.jc.test;

import com.jc.dao.EmployeeDao;
import com.jc.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class demo1 {

    InputStream in = null;
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    EmployeeDao employeeDao = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     * 查询所有员工
     */
    @Test
    public void test1(){
        List<Employee> employeeAll = employeeDao.findEmployeeAll();
        for (Employee employee : employeeAll) {
            System.out.println(employee);
        }
    }

    /**
     * 查询所有员工(原生操作，不使用代理对象)
     */
    @Test
    public void test10(){
        List<Object> objects = sqlSession.selectList("com.jc.dao.EmployeeDao.findEmployeeAll");
        for (Object object : objects) {
            System.out.println(object);
        }
        Object o = sqlSession.selectOne("com.jc.dao.EmployeeDao.findEmployeeById", 1);
        System.out.println(o);

    }

    /**
     * 根据员工id查询信息(演示一级缓存)
     */
    @Test
    public void test11(){
        Employee employee1 = employeeDao.findEmployeeById(1);
        System.out.println(employee1);
//        sqlSession.clearCache();
        Employee employee2 = employeeDao.findEmployeeById(1);
        System.out.println(employee2);
        System.out.println(employee1==employee2);
    }


    /**
     * 根据员工id查询信息(演示二级缓存)
     */
    @Test
    public void test12(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmployeeDao employeeDao1 = sqlSession1.getMapper(EmployeeDao.class);
        Employee employee1 = employeeDao1.findEmployeeById(1);
        System.out.println(employee1);
        sqlSession1.clearCache();
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmployeeDao employeeDao2 = sqlSession2.getMapper(EmployeeDao.class);
        Employee employee2 = employeeDao2.findEmployeeById(1);
        System.out.println(employee2);
        sqlSession2.clearCache();
        sqlSession2.close();
    }

    /**
     * 查询所有部门
     */
    @Test
    public void test2(){
        List<Department> departmentAll = employeeDao.findDepartmentAll();
        for (Department department : departmentAll) {
            System.out.println(department);
        }
    }

    /**
     * 根据部门id查询信息(
     */
    @Test
    public void test21(){
        Department department = employeeDao.findDepartmentById(3);
        System.out.println(department);
    }


    /**
     * 查询所有员工及其所属部门 (一对一/多对一)【可延迟加载】
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        List<EmployeeDep> employees = employeeDao.findEmployeeDep();
        for (EmployeeDep employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 查询所有部门及其内员工（一对多）【可延迟加载】
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        List<DepartmentEmp> departmentEmps = employeeDao.findDepartmentEmp();
        for (DepartmentEmp departmentEmp : departmentEmps) {
            System.out.println(departmentEmp);
        }
    }

    //----------------------动态SQL---------------------------------
    @Test
    public void test5(){
        Employee employee = new Employee();
//        employee.setName("%川%");
        employee.setSex("女");
        List<Employee> fuzzyEmployee = employeeDao.findFuzzyEmployee(employee);
        for (Employee employee1 : fuzzyEmployee) {
            System.out.println(employee1);
        }
    }

    @Test
    public void test6(){
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        queryVo.setIds(list);
        List<Employee> employeeByIds = employeeDao.findEmployeeByIds(queryVo);
        for (Employee employeeById : employeeByIds) {
            System.out.println(employeeById);
        }
    }



}
