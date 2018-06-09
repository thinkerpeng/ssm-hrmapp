package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.entity.Notice;

import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/9.
 */
public interface NoticeDao {

    /**
     * 动态查询公告
     * @param params params
     * @return notices
     */
    List<Notice> selectByParam(Map<String, Object> params);

    /**
     * 统计公告数量
     * @param params params
     * @return 公告数量
     */
    Integer count(Map<String, Object> params);

    /**
     * 根据id查询公告
     * @param id id
     * @return notice
     */
    Notice selectById(int id);

    /**
     *  根据id删除公告
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 动态插入公告
     * @param notice notice
     */
    void save(Notice notice);

    /**
     * 动态修改公告
     * @param notice notice
     */
    void update(Notice notice);
}
