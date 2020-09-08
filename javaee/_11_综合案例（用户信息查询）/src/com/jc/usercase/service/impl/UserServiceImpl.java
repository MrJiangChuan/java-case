package com.jc.usercase.service.impl;

import com.jc.usercase.dao.UserDao;
import com.jc.usercase.dao.impl.UserDaoImpl;
import com.jc.usercase.entity.Manager;
import com.jc.usercase.entity.PageBreak;
import com.jc.usercase.entity.User;
import com.jc.usercase.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 查询登录用户
     *
     * @param user
     * @return
     */
    @Override
    public Manager findUser(Manager user) {
        return userDao.findUser(user);
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAllusers() {
        return userDao.findAllusers();
    }

    /**
     * 插入用户数据
     *
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    /**
     * 删除指定id的用户
     *
     * @param id
     * @return
     */
    @Override
    public int delUserbyId(int id) {

        return userDao.delUserbyId(id);
    }

    /**
     * 批量删除指定id用户
     *
     * @param ids
     * @return
     */
    @Override
    public int delUserbyIds(int[] ids) {

        return userDao.delUserbyIds(ids);
    }

    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {

        return userDao.updateUser(user);
    }

    /**
     * 查分页询用户信息
     *
     * @param currentPage 当前页码
     * @param itemPerPage 每页显示条目
     * @return
     */
    @Override
    public PageBreak<User> findPageUsers(int currentPage, int itemPerPage) {

        if(currentPage<=0) currentPage=1;
        if(itemPerPage<=0) itemPerPage=5;

        PageBreak<User> userPageBreak = new PageBreak<>();
        //设置当前页
        userPageBreak.setCurrentPage(currentPage);
        //设置每页显示条目
        userPageBreak.setItemPerPage(itemPerPage);
        int totalCount = userDao.findTotalCount();
        //设置总记录数
        userPageBreak.setTotal(totalCount);
        int totalPage = totalCount % itemPerPage == 0 ? totalCount / itemPerPage : totalCount / itemPerPage + 1;
        //设置总页数
        userPageBreak.setTotalPage(totalPage);
        int start = (currentPage - 1) * itemPerPage;
        List<User> pageItems = userDao.findPageItems(start, itemPerPage);
        //设置列表项
        userPageBreak.setItems(pageItems);
        return userPageBreak;
    }

    /**
     * 模糊查询用户信息
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @return
     */
    @Override
    public List<User> fuzzyQueryUsers(String realName, String address, String email) {
        return userDao.fuzzyQueryUsers(realName,address,email);
    }

    /**
     * 分页模糊查询用户信息
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @param currentPage 当前页
     * @param itemPerPage 每页显示条目
     * @return
     */
    @Override
    public PageBreak<User> fuzzyPageQueryUsers(String realName, String address, String email, int currentPage, int itemPerPage) {
        if(currentPage<=0) currentPage=1;
        if(itemPerPage<=0) itemPerPage=5;

        PageBreak<User> userPageBreak = new PageBreak<>();
        //设置当前页
        userPageBreak.setCurrentPage(currentPage);
        //设置每页显示条目
        userPageBreak.setItemPerPage(itemPerPage);
        int totalCount = userDao.findFuzzyTotalCount(realName,address,email);
        //设置总记录数
        userPageBreak.setTotal(totalCount);
        int totalPage = totalCount % itemPerPage == 0 ? totalCount / itemPerPage : totalCount / itemPerPage + 1;
        //设置总页数
        userPageBreak.setTotalPage(totalPage);
        int start = (currentPage - 1) * itemPerPage;
        List<User> pageItems = userDao.findFuzzyPageItems(realName,address,email,start, itemPerPage);
        //设置列表项
        userPageBreak.setItems(pageItems);
        return userPageBreak;

    }
}
