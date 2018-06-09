package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.entity.Job;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/6.
 */
public class JobDaoTest extends BaseTest {

    @Autowired
    private JobDao jobDao;

    @Test
    public void selectByParam() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("name", "总经理");
        List<Job> jobList =  jobDao.selectByParam(param);
        jobList.forEach(job -> {
            System.out.println(job);
        });
    }

    @Test
    public void count() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("name", "总经理");
        Integer count =  jobDao.count(param);
        System.out.println(count);
    }

    @Test
    public void selectAllJob() throws Exception {
        List<Job> jobList = jobDao.selectAllJob();
        jobList.forEach(job -> {
            System.out.println(job.getId() + ", " + job.getName());
        });
    }

    @Test
    public void selectById() throws Exception {
        Job job = jobDao.selectById(2);
        System.out.println(job.getId() + ", " + job.getName());
    }

    @Test
    public void deleteById() throws Exception {
        jobDao.deleteById(10);
        Job job = jobDao.selectById(8);
        if (job != null) {
            System.out.println(job.getId() + ", " + job.getName());
        } else {
            System.out.println("null");
        }
    }

    @Test
    public void save() throws Exception {
        Job job = new Job();
        job.setId(10);
        job.setName("老板");
        jobDao.save(job);
        Job job1 = jobDao.selectById(10);
        if (job1 != null) {
            System.out.println(job1.getId() + ", " + job1.getName());
        } else {
            System.out.println("insert fail!");
        }
    }

    @Test
    public void update() throws Exception {
        Job job = new Job();
        job.setId(10);
        job.setName("彭伟响");
        jobDao.update(job);
        Job job1 = jobDao.selectById(10);
        if (job1 != null) {
            System.out.println(job1.getId() + ", " + job1.getName());
        } else {
            System.out.println("insert fail!");
        }
    }
}
