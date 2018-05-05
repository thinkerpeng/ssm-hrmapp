package com.pwx.ssmdemo.entity;

/**
 * Created by peng on 2018/5/2.
 */
public class Book {

    /**
     * 图书ID
     */
    private long bookId;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 馆藏数量
     */
    private int number;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book [" +
                "bookId=" + bookId +
                ", name=" + name +
                ", number=" + number +
                "]";
    }
}
