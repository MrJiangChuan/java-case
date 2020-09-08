package com.jc.test;

import com.jc.dao.DepEmpDao;
import com.jc.dao.EmpDepDao;
import com.jc.dao.EmployeeDao;
import com.jc.entity.DepEmp;
import com.jc.entity.Department;
import com.jc.entity.EmpDep;
import com.jc.entity.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo1 {
    InputStream in = null;
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    EmployeeDao employeeDao = null;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sqlSessionFactory工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.创建sqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //4.创建employeeDao代理对象
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
    }

    @After
    public void destroy() throws IOException {
        //1.提交事务
        sqlSession.commit();
        //2.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 查询所有员工
     */
    @Test
    public void test1(){
        List<Employee> employees = employeeDao.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 根据员工id查询员工信息
     */
    @Test
    public void test2(){
        Employee employee = employeeDao.findById(3);
        System.out.println(employee);
    }

    /**
     * 模糊查询员工信息
     */
    @Test
    public void test3(){
        Employee employee = new Employee();
        employee.setName("%赵%");
        employee.setSex(" ' or '1");
        List<Employee> fuzzyEmployees = employeeDao.findFuzzy(employee);
        for (Employee fuzzyEmployee : fuzzyEmployees) {
            System.out.println(fuzzyEmployee);
        }
    }

    /**
     * 查询员工总数
     */
    @Test
    public void test4(){
        Integer total = employeeDao.findTotal();
        System.out.println(total);
    }

    /**
     * 增加员工
     */
    @Test
    public void test5(){
        Employee employee = new Employee();
        employee.setName("刘一手");
        employee.setAge(36);
        employee.setSex("男");
        employee.setDep_id(3);
        Integer insert = employeeDao.insert(employee);
        System.out.println(insert);
    }

    /**
     * 更新员工信息
     */
    @Test
    public void test6(){
        Employee employee = new Employee();
        employee.setUid(12);
        employee.setName("刘一手");
        employee.setAge(26);
        employee.setSex("女");
        employee.setDep_id(1);
        Integer update = employeeDao.update(employee);
        System.out.println(update);
    }

    /**
     * 删除某个员工
     */
    @Test
    public void test7(){
        Integer delete = employeeDao.delete(12);
        System.out.println(delete);
    }

    /**
     * 查询所有员信息，根据需要延迟加载其部门信息
     */
    @Test
    public void test8(){
        EmpDepDao empDepDao = sqlSession.getMapper(EmpDepDao.class);
        List<EmpDep> empdeps = empDepDao.findAll();
        for (EmpDep empdep : empdeps) {
            System.out.println(empdep);
        }
    }

    /**
     * 查询所有部门，及其员工，延迟加载
     */
    @Test
    public void test9(){
        DepEmpDao depEmpDao = sqlSession.getMapper(DepEmpDao.class);
        List<DepEmp> depEmps = depEmpDao.findAll();
        for (DepEmp depEmp : depEmps) {
            System.out.println(depEmp);
        }
    }

    /**
     * 演示二级缓存
     */
    @Test
    public void test10(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmployeeDao mapper = sqlSession1.getMapper(EmployeeDao.class);
        Employee byId = mapper.findById(1);
        System.out.println(byId);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmployeeDao mapper1 = sqlSession2.getMapper(EmployeeDao.class);
        Employee byId1 = mapper1.findById(1);
        System.out.println(byId1);
        sqlSession2.close();
    }
}
