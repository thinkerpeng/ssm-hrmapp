package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.entity.Dept;
import com.pwx.hrmapp.entity.Employee;
import com.pwx.hrmapp.entity.Job;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/8.
 */
public class EmployeeDaoTest extends BaseTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void count() {
        Map<String, Object> param = new HashMap<>();
        Dept dept = new Dept();
        dept.setId(8);
        param.put("dept", dept);
        param.put("name", "爱丽丝");
        Integer count = employeeDao.count(param);
        System.out.println(count);
    }

    @Test
    public void selectByParam() {
        Map<String, Object> param = new HashMap<>();
        Dept dept = new Dept();
        dept.setId(1);
        param.put("dept", dept);
        param.put("name", "爱丽丝");
        List<Employee> employeeList = employeeDao.selectByParam(param);
        employeeList.forEach(employee -> {
            System.out.println(employee.getId() + ", " + employee.getName() + ", "
                    + employee.getDept().getName() + ", " + employee.getJob().getName() + ", "
                    + new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirthday()));
        });
    }

    @Test
    public void save() {
        Employee employee = new Employee();
        Dept dept = new Dept();
        dept.setId(1);
        Job job = new Job();
        job.setId(1);
        employee.setName("彭伟响");
        employee.setCardId("00001");
        employee.setAddress("深圳龙岗区坂田街道中心围");
        employee.setPhone("15017908330");
        employee.setEmail("664205468@qq.com");
        employee.setSex(0);
        employee.setDept(dept);
        employee.setJob(job);
        employeeDao.save(employee);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        Dept dept = new Dept();
        dept.setId(1);
        Job job = new Job();
        job.setId(1);
        employee.setName("小明");
        employee.setId(4);
        employeeDao.update(employee);
    }

    @Test
    public void selectById() {
        Employee employee = employeeDao.selectById(4);
        if (employee != null) {
            System.out.println(employee.getName());
            System.out.println(employee.getBirthday());
        }
    }

    @Test
    public void deleteById() {
        employeeDao.deleteById(4);
        Employee employee = employeeDao.selectById(4);
        if (employee != null) {
            System.out.println(employee.getName());
            System.out.println(employee.getBirthday());
        }
    }
}
