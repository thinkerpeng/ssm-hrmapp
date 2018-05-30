package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/5/7.
 */
public interface UserDao {

    /**
     * 根据登录名和密码查询员工
     * @param loginname
     * @param password
     * @return
     */
    User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectById(@Param("id") String id);

    /**
     * 根据id删除用户
     * @param id
     */
    void delteUser(@Param("id") String id);

    /**
     * 根据id修改用户
     * @param id
     */
    void updateUser(@Param("id") String id);

    /**
     * 插入用户
     * @param user
     */
    void saveUser(@Param("user") User user);

    /**
     * 分页动态查询
     * @param params
     * @return
     */
    List<User> selectByParam(Map<String, Object> params);

    /**
     * 根据参数查询用户总数
     * @param params
     * @return
     */
    Integer count(Map<String, Object> params);
}
