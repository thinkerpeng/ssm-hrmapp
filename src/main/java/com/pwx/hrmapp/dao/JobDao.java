package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.entity.Job;

import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/7.
 */
public interface JobDao {

    /**
     * 根据id查询职位
     * @param id id
     * @return 职位
     */
    Job selectById(int id);

    /**
     * 查询所有的职位
     * @return list
     */
    List<Job> selectAllJob();

    /**
     * 分页动态查询
     * @param params 查询条件
     * @return list
     */
    List<Job> selectByParam(Map<String, Object> params);

    /**
     * 动态查询总数量
     * @param params 查询条件
     * @return Integer
     */
    Integer count(Map<String, Object> params);

    /**
     * 根据id删除职位
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 动态插入职位
     * @param job job
     */
    void save(Job job);

    /**
     * 动态修改职位
     * @param job job
     */
    void update(Job job);
}
