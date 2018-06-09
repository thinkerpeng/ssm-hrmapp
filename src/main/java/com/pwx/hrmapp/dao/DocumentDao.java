package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.entity.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/9.
 */
public interface DocumentDao {

    /**
     * 动态查询
     * @param params params
     * @return 文档列表
     */
    List<Document> selectByParam(Map<String, Object> params);

    /**
     * 查询总数
     * @param params params
     * @return 总数
     */
    Integer count(Map<String, Object> params);

    /**
     * 动态插入文档
     * @param document document
     */
    void save(Document document);

    /**
     * 根据id查找文档
     * @param id id
     * @return document
     */
    Document selectById(int id);

    /**
     * 根据id删除文档
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 动态更新文档
     * @param document document
     */
    void update(Document document);
}
