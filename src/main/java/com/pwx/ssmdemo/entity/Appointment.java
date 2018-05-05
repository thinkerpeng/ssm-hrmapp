package com.pwx.ssmdemo.entity;

import java.util.Date;

/**
 * Created by peng on 2018/5/2.
 */
public class Appointment {

    /**
     * 图书ID
     */
    private long bookId;

    /**
     * 学号
     */
    private long studentId;

    /**
     * 预约时间
     */
    private Date appointTime;

    /**
     * 多对一的复合属性
     */
    private Book book;

    @Override
    public String toString() {
        return "Appointment [" +
                "bookId=" + bookId +
                ", bookName=" + book.getName() +
                ", bookNumber=" + book.getNumber() +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                "]";
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
