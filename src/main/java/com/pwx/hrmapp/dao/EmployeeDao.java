package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.entity.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/8.
 */
public interface EmployeeDao {

    /**
     * 根据参数查询员工总数
     * @param params params
     * @return 总数
     */
    Integer count(Map<String, Object> params);

    /**
     * 根据参数动态查询员工
     * @param params params
     * @return 员工列表
     */
    List<Employee> selectByParam(Map<String, Object> params);

    /**
     * 动态插入员工
     * @param employee employee
     */
    void save(Employee employee);

    /**
     * 根据id删除员工
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 根据id查询员工
     * @param id id
     * @return employee
     */
    Employee selectById(Integer id);

    /**
     * 动态修改员工
     * @param employee employee
     */
    void update(Employee employee);
}
