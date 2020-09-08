package com.jc.usercase.dao.impl;

import com.jc.usercase.dao.UserDao;
import com.jc.usercase.entity.Manager;
import com.jc.usercase.entity.User;
import com.jc.usercase.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询登录用户
     *
     * @param user
     * @return
     */
    @Override
    public Manager findUser(Manager user) {
        String sql = "select * from login_info where username = ? and password = ?";
        System.out.println(1111);
        Manager user1 = null;
        try {
            user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Manager>(Manager.class), user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user1;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAllusers() {
        String sql = "select * from user_info";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    /**
     * 插入用户数据
     *
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        String sql = "insert into user_info values(null,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getRealName(), user.getSex(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());
    }

    /**
     * 删除指定id的用户
     *
     * @param id
     * @return
     */
    @Override
    public int delUserbyId(int id) {

        String sql = "delete from user_info where id = ?";
        return jdbcTemplate.update(sql, id);

    }

    /**
     * 批量删除指定id用户
     *
     * @param ids
     * @return
     */
    @Override
    public int delUserbyIds(int[] ids) {

        String sql = "delete from user_info where id = ?";
        for (int id : ids) {
            jdbcTemplate.update(sql, id);
        }
        return ids.length;
    }

    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        String sql = "update user_info set realName=?,sex=?,age=?,address=?,qq=?,email=? where id=?";
        return jdbcTemplate.update(sql, user.getRealName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    /**
     * 分页查询用户信息
     *
     * @param start       起始索引
     * @param itemPerPage 每页显示条目
     * @return
     */
    @Override
    public List<User> findPageItems(int start, int itemPerPage) {
        String sql = "select * from user_info limit ?,?";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), start, itemPerPage);
        return query;
    }

    /**
     * 查询总的记录数
     *
     * @return
     */
    @Override
    public int findTotalCount() {
        String sql = "select count(*) from user_info";
        return jdbcTemplate.queryForObject(sql, int.class);
    }

    /**
     * 模糊查询用户信息
     *
     * @param realName 姓名
     * @param address  籍贯
     * @param email    邮箱
     * @return
     */
    @Override
    public List<User> fuzzyQueryUsers(String realName, String address, String email) {
//        //如果所有参数都为空，直接返回空集合
//        if ((realName == null || "".equals(realName.trim())) && (address == null || "".equals(address.trim())) && (email == null || "".equals(email.trim()))) {
//            return new ArrayList<User>();
//        }

        String sqlTemplate = "select * from user_info where 1 = 1";
        StringBuilder sb = new StringBuilder(sqlTemplate);
        List<String> strs = new ArrayList<>();

        //根据参数条件动态生成sql
        if (realName != null && !"".equals(realName.trim())) {
            sb.append(" and realName like ?");
            strs.add(realName);
        }
        if (address != null && !"".equals(address.trim())) {
            sb.append(" and address like ?");
            strs.add(address);
        }
        if (email != null && !"".equals(email.trim())) {
            sb.append(" and email like ?");
            strs.add(email);
        }

        String sql = sb.toString();
        Object[] params =  strs.toArray();
        for (int i = 0; i < params.length; i++) {
            params[i]="%"+params[i]+"%";
        }
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), params);
    }

    /**
     * 模糊查询总的记录数
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @return
     */
    @Override
    public int findFuzzyTotalCount(String realName,String address,String email) {
        String sqlTemplate = "select count(*) from user_info where 1 = 1";
        StringBuilder sb = new StringBuilder(sqlTemplate);
        List<String> strs = new ArrayList<>();

        //根据参数条件动态生成sql
        if (realName != null && !"".equals(realName.trim())) {
            sb.append(" and realName like ?");
            strs.add(realName);
        }
        if (address != null && !"".equals(address.trim())) {
            sb.append(" and address like ?");
            strs.add(address);
        }
        if (email != null && !"".equals(email.trim())) {
            sb.append(" and email like ?");
            strs.add(email);
        }

        String sql = sb.toString();
        Object[] params =  strs.toArray();
        for (int i = 0; i < params.length; i++) {
            params[i]="%"+params[i]+"%";
        }
        return jdbcTemplate.queryForObject(sql, int.class, params);
    }

    /**
     * 模糊分页查询用户信息
     * @param realName 姓名
     * @param address 籍贯
     * @param email 邮箱
     * @param start 起始索引
     * @param itemPerPage 每页显示条目
     * @return
     */
    @Override
    public List<User> findFuzzyPageItems(String realName, String address, String email, int start, int itemPerPage) {
        String sqlTemplate = "select * from user_info where 1 = 1";
        StringBuilder sb = new StringBuilder(sqlTemplate);
        List<Object> strs = new ArrayList<>();

        //根据参数条件动态生成sql
        if (realName != null && !"".equals(realName.trim())) {
            sb.append(" and realName like ?");
            strs.add(realName);
        }
        if (address != null && !"".equals(address.trim())) {
            sb.append(" and address like ?");
            strs.add(address);
        }
        if (email != null && !"".equals(email.trim())) {
            sb.append(" and email like ?");
            strs.add(email);
        }
        sb.append(" limit ?,?");
        String sql = sb.toString();

        for (int i = 0; i < strs.size(); i++) {
            strs.set(i,"%"+strs.get(i)+"%");
        }
        strs.add(start);
        strs.add(itemPerPage);
        Object[] params =  strs.toArray();
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), params);
    }
}
