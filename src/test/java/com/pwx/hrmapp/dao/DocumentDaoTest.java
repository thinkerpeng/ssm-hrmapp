package com.pwx.hrmapp.dao;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.entity.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by peng on 2018/6/9.
 */
public class DocumentDaoTest extends BaseTest {

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void save() throws Exception {
        Document document = new Document();
        document.setFilename("DocumentDao.java");
        document.setTitle("Spring+Mybatis企业应用实战");
        document.setUser(userDao.selectById("1"));
        documentDao.save(document);
    }

    @Test
    public void selectById() throws Exception {
        Document document = documentDao.selectById(1);
        if (document != null) {
            System.out.println(document.getFilename() + ", " + document.getTitle() + ", "
                    + document.getUser().getUsername());
        }
    }

    @Test
    public void deleteById() throws Exception {
        documentDao.deleteById(3);
        Document document = documentDao.selectById(3);
        if (document != null) {
            System.out.println(document.getFilename() + ", " + document.getTitle() + ", "
                    + document.getUser().getUsername());
        }
    }

    @Test
    public void update() throws Exception {
        Document document = new Document();
        document.setFilename("Main.java");
        document.setTitle("Spring 实战");
        document.setId(4);
        documentDao.update(document);
    }

    @Test
    public void count() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("title", "spring");
        Integer count = documentDao.count(param);
        System.out.println(count);
    }

    @Test
    public void selectByParam() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("title", "spring");
        List<Document> documentList = documentDao.selectByParam(param);
        documentList.forEach(document -> {
            System.out.println(document.getFilename() + ", " + document.getTitle() + ", "
                    + document.getUser().getUsername());
        });
    }
}
