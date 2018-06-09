package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.entity.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/5.
 */
public interface DeptDao {

    /**
     * 动态查询
     * @param params 查询条件
     * @return 部门
     */
    List<Dept> selectByParam(Map<String, Object> params);

    /**
     * 动态查询统计
     * @param params 查询条件
     * @return 统计的数量
     */
    Integer count(Map<String, Object> params);

    /**
     * 查询所有的部门
     * @return 所有部门的集合
     */
    List<Dept> selectAllDept();

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 部门对象
     */
    Dept selectById(int id);

    /**
     * 根据id删除部门
     * @param id 部门id
     */
    void deleteById(Integer id);

    /**
     * 动态插入部门
     * @param dept 部门对象
     */
    void save(Dept dept);

    /**
     * 动态修改用户
     * @param dept 部门对象
     */
    void update(Dept dept);
}
