package com.jc.usercase.dao;

import com.jc.usercase.entity.Manager;
import com.jc.usercase.entity.PageBreak;
import com.jc.usercase.entity.User;

import java.util.List;

public interface UserDao {

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
     * @param start       起始索引
     * @param itemPerPage 每页显示条目
     * @return
     */
    List<User> findPageItems(int start, int itemPerPage);

    /**
     * 查询总的记录数
     *
     * @return
     */
    int findTotalCount();

    /**
     * 模糊查询用户信息
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @return
     */
    List<User> fuzzyQueryUsers(String realName, String address, String email);

    /**
     * 模糊查询总的记录数
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @return
     */
    int findFuzzyTotalCount(String realName,String address,String email);

    /**
     * 模糊分页查询用户信息
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @param start 起始索引
     * @param itemPerPage 每页显示条目
     * @return
     */
    List<User> findFuzzyPageItems(String realName, String address, String email, int start, int itemPerPage);

}
