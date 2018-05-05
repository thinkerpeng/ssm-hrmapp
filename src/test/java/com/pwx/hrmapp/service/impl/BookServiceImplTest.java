package com.pwx.hrmapp.service.impl;

import com.pwx.hrmapp.BaseTest;
import com.pwx.hrmapp.dto.AppointExecution;
import com.pwx.hrmapp.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by peng on 2018/5/4.
 */
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1002;
        long studentId = 12345678910L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }
}
