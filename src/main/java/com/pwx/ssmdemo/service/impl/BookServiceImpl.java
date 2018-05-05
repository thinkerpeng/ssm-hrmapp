package com.pwx.ssmdemo.service.impl;

import com.pwx.ssmdemo.dao.AppointmentDao;
import com.pwx.ssmdemo.dao.BookDao;
import com.pwx.ssmdemo.dto.AppointExecution;
import com.pwx.ssmdemo.entity.Appointment;
import com.pwx.ssmdemo.entity.Book;
import com.pwx.ssmdemo.enums.AppointStateEnum;
import com.pwx.ssmdemo.exception.AppointException;
import com.pwx.ssmdemo.exception.NoNumberException;
import com.pwx.ssmdemo.exception.RepeatAppointException;
import com.pwx.ssmdemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实现类必须加上@Service注解
 */
@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0, 1000);
    }

    @Override
    @Transactional
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0) {
                throw new NoNumberException("no number");
            } else {
                // 执行预约操作
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {
                    // 重复预约
                    throw new RepeatAppointException("repeat appoint");
                } else {
                    // 预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        } catch (NoNumberException e) {
            throw e;
        } catch (RepeatAppointException e) {
            throw e;
        } catch (Exception e) {
            // 所有编译期异常转换为运行期异常
            logger.error(e.getMessage(), e);
            throw new AppointException("appoint inner error: " + e.getMessage());
        }
    }
}
