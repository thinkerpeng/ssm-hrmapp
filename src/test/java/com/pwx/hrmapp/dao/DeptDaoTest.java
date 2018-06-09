package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.entity.Dept;
import com.pwx.hrmapp.util.tag.PageModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2018/6/6.
 */
public class DeptDaoTest extends BaseTest {

    @Autowired
    private DeptDao deptDao;

    @Test
    public void selectByParam() throws Exception {
        Map<String, Object> param = new HashMap<>();
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(6);
        pageModel.setPageIndex(2);
        pageModel.setPageSize(5);
        //param.put("name", "技术部");
        param.put("pageModel", pageModel);
        List<Dept> deptList =  deptDao.selectByParam(param);
        deptList.forEach(dept -> {
            System.out.println(dept);
        });
    }

    @Test
    public void count() throws Exception {
        Map<String, Object> param = new HashMap<>();
        //param.put("name", "技术部");
        Integer count =  deptDao.count(param);
        System.out.println(count);
    }

    @Test
    public void selectAllDept() throws Exception {
        List<Dept> deptList = deptDao.selectAllDept();
        deptList.forEach(dept -> {
            System.out.println(dept.getId() + ", " + dept.getName());
        });
    }

    @Test
    public void selectById() throws Exception {
        Dept dept = deptDao.selectById(2);
        System.out.println(dept.getId() + ", " + dept.getName());
    }

    @Test
    public void deleteById() throws Exception {
        deptDao.deleteById(8);
        Dept dept = deptDao.selectById(8);
        if (dept != null) {
            System.out.println(dept.getId() + ", " + dept.getName());
        } else {
            System.out.println("null");
        }
    }

    @Test
    public void save() throws Exception {
        Dept dept = new Dept();
        dept.setId(8);
        dept.setName("测试单元");
        deptDao.save(dept);
        Dept dept1 = deptDao.selectById(8);
        if (dept1 != null) {
            System.out.println(dept1.getId() + ", " + dept1.getName());
        } else {
            System.out.println("insert fail!");
        }
    }

    @Test
    public void update() throws Exception {
        Dept dept = new Dept();
        dept.setId(8);
        dept.setName("更新后的测试单元");
        deptDao.update(dept);
        Dept dept1 = deptDao.selectById(8);
        if (dept1 != null) {
            System.out.println(dept1.getId() + ", " + dept1.getName());
        } else {
            System.out.println("insert fail!");
        }
    }
}
