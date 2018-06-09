package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.entity.Notice;
import com.pwx.hrmapp.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/9.
 */
public class NoticeDaoTest extends BaseTest {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void save() throws Exception {
        Notice notice = new Notice();
        notice.setTitle("公告二");
        notice.setContent("彭伟响，很牛逼！！！");
        User user = userDao.selectById("2");
        if (user != null) {
            notice.setUser(user);
        }
        noticeDao.save(notice);
    }

    @Test
    public void update() throws Exception {
        Notice notice = new Notice();
        notice.setId(3);
        notice.setContent("彭伟响，很努力！");
        User user = userDao.selectById("1");
        if (user != null) {
            notice.setUser(user);
            System.out.println("=================" + user.getId());
        }
        noticeDao.update(notice);
    }

    @Test
    public void selectById() throws Exception {
        Notice notice = noticeDao.selectById(1);
        if (notice != null) {
            System.out.println(notice.getTitle() + ", " + notice.getContent());
        }
    }

    @Test
    public void selectByParam() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("title", "公告");
        param.put("content", "彭伟响");
        List<Notice> noticeList =  noticeDao.selectByParam(param);
        noticeList.forEach(notice -> {
            System.out.println(notice.getTitle() + ", " + notice.getContent());
        });
    }

    @Test
    public void count() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("title", "公告");
        param.put("content", "周末");
        Integer count = noticeDao.count(param);
        System.out.println(count);
    }

    @Test
    public void deleteById() throws Exception {
        noticeDao.deleteById(3);
        Notice notice = noticeDao.selectById(3);
        if (notice != null) {
            System.out.println(notice.getTitle() + ", " + notice.getContent());
        }
    }
}
