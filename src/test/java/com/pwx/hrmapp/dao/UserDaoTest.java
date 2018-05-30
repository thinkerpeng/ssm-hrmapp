package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by peng on 2018/5/7.
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void selectByLoginnameAndPassword() throws Exception {
        String loginname = "admin";
        String password = "123456";
        User user = userDao.selectByLoginnameAndPassword(loginname, password);
        System.out.println(user.getUsername());
    }

    @Test
    public void selectById() throws Exception {
        String id = "1";
        User user = userDao.selectById(id);
        System.out.println(user.getUsername() + ", id: " + user.getId());
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setLoginname("pengweixiang");
        user.setPassword("123456");
        user.setUsername("彭伟响");
        userDao.saveUser(user);
    }

    public void delteUser() throws Exception {

    }
}
