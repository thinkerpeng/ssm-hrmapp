package com.pwx.hrmapp.service;

import com.pwx.hrmapp.entity.User;
import com.pwx.hrmapp.util.tag.PageModel;

import java.util.List;

/**
 * 人事管理服务层接口
 * Created by peng on 2018/6/9.
 */
public interface HrmService {

    /**
     * 用户登录
     * @param loginname loginname
     * @param password password
     * @return User对象
     */
    User login(String loginname, String password);

    /**
     * 根据id查询用户
     * @param id id
     * @return 用户对象
     * */
    User findUserById(Integer id);

    /**
     * 获得所有用户
     * @return User对象的List集合
     * */
    List<User> findUser(User user, PageModel pageModel);
}
