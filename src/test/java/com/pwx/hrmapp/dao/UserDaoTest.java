package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        user.setLoginname("pengweixiang111");
        user.setPassword("12345678");
        user.setStatus(1);
        user.setUsername("彭伟响111");
        userDao.saveUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        String id = "2";
        userDao.deleteUser(id);
    }

    @Test
    public void updateUser() throws Exception {
        User user = userDao.selectById("3");
        if (user != null) {
            user.setUsername("彭伟响");
            user.setPassword("mikepeng*361");
            userDao.updateUser(user);
        }
    }

    @Test
    public void selectByParam() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("username", "彭伟响");
        param.put("start", 2);
        param.put("size", 5);
        List<User> userList = userDao.selectByParam(param);
        userList.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void count() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("username", "彭伟响");
        Integer count = userDao.count(param);
        System.out.println(count);
    }
}
