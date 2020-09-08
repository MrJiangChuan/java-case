package com.jc.usercase.service;

import com.jc.usercase.entity.Manager;
import com.jc.usercase.entity.PageBreak;
import com.jc.usercase.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询登录用户
     *
     * @param user
     * @return
     */
    Manager findUser(Manager user);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findAllusers();

    /**
     * 插入用户数据
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 删除指定id的用户
     *
     * @param id
     * @return
     */
    int delUserbyId(int id);

    /**
     * 批量删除指定id用户
     *
     * @param ids
     * @return
     */
    int delUserbyIds(int[] ids);

    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 分页查询用户信息
     *
     * @param currentPage 当前页码
     * @param itemPerPage 每页显示条目
     * @return
     */
    PageBreak<User> findPageUsers(int currentPage, int itemPerPage);

    /**
     * 模糊查询用户信息
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @return
     */
    List<User> fuzzyQueryUsers(String realName, String address, String email);

    /**
     * 分页模糊查询用户信息
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @param currentPage 当前页
     * @param itemPerPage 每页显示条目
     * @return
     */
    PageBreak<User> fuzzyPageQueryUsers(String realName, String address, String email, int currentPage, int itemPerPage);
}
