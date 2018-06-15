package com.pwx.hrmapp.service.impl;

import com.pwx.hrmapp.dao.*;
import com.pwx.hrmapp.entity.*;
import com.pwx.hrmapp.service.HrmService;
import com.pwx.hrmapp.util.tag.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人事管理系统服务层接口实现类
 * Created by peng on 2018/6/10.
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 自动注入持久层Dao对象
     */
    @Autowired
    private UserDao userDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private DocumentDao documentDao;

    @Transactional(readOnly = true)
    @Override
    public User login(String loginname, String password) {
        LOGGER.info("HrmServiceImpl login -- >>");
        return userDao.selectByLoginnameAndPassword(loginname, password);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> findUser(User user, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        int recordCount = userDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0){
            params.put("pageModel" , pageModel);
        }
        List<User> users = userDao.selectByParam(params);

        return users;
    }

    @Override
    public void removeUserById(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("employee", employee);
        int recordCount = employeeDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0){
            params.put("pageModel", pageModel);
        }

        List<Employee> employees = employeeDao.selectByParam(params);
        return employees;
    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.selectById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dept> findDept(Dept dept, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("dept", dept);
        int recordCount = deptDao.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            params.put("pageModel", pageModel);
        }

        List<Dept> depts = deptDao.selectByParam(params);

        return depts;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }

    @Override
    public void removeDeptById(Integer id) {
        deptDao.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.save(dept);
    }

    @Transactional(readOnly = true)
    @Override
    public Dept findDeptById(Integer id) {
        return deptDao.selectById(id);
    }

    @Override
    public void modifyDept(Dept dept) {
        deptDao.update(dept);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Job> findAllJob() {
        return jobDao.selectAllJob();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Job> findJob(Job job, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("job", job);
        int recordCount = jobDao.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            params.put("pageModel", pageModel);
        }

        List<Job> jobs = jobDao.selectByParam(params);

        return jobs;
    }

    @Override
    public void removeJobById(Integer id) {
        jobDao.deleteById(id);
    }

    @Override
    public void addJob(Job job) {
        jobDao.save(job);
    }

    @Transactional(readOnly = true)
    @Override
    public Job findJobById(Integer id) {
        return jobDao.selectById(id);
    }

    @Override
    public void modifyJob(Job job) {
        jobDao.update(job);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Notice> findNotice(Notice notice, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("notice", notice);
        int recordCount = noticeDao.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            params.put("pageModel", pageModel);
        }

        List<Notice> notices = noticeDao.selectByParam(params);

        return notices;
    }

    @Transactional(readOnly = true)
    @Override
    public Notice findNoticeById(Integer id) {
        return noticeDao.selectById(id);
    }

    @Override
    public void removeNoticeById(Integer id) {
        noticeDao.deleteById(id);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeDao.save(notice);
    }

    @Override
    public void modifyNotice(Notice notice) {
        noticeDao.update(notice);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Document> findDocument(Document document, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("document", document);
        int recordCount = documentDao.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }

        List<Document> documents = documentDao.selectByParam(params);

        return documents;
    }

    @Override
    public void addDocument(Document document) {
        documentDao.save(document);
    }

    @Transactional(readOnly=true)
    @Override
    public Document findDocumentById(Integer id) {
        return documentDao.selectById(id);
    }

    @Override
    public void removeDocumentById(Integer id) {
        documentDao.deleteById(id);
    }

    @Override
    public void modifyDocument(Document document) {
        documentDao.update(document);
    }
}
