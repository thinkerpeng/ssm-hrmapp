package com.pwx.ssmdemo.dao;

import com.pwx.ssmdemo.BaseTest;
import com.pwx.ssmdemo.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * Created by peng on 2018/5/2.
 */
public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    String url="jdbc:mysql://localhost:3306/mybatis";
    String name="root";
    String pwd="123456";
    @Test
    public void closeAll() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,name,pwd);
        System.out.println(conn);
    }

    @Test
    public void testQueryById() throws Exception {
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Book> books = bookDao.queryAll(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        long bookId = 1002;
        int update = bookDao.reduceNumber(bookId);
        System.out.println("update=" + update);
    }
}
