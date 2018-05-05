package com.pwx.ssmdemo.dto;

import com.pwx.ssmdemo.entity.Appointment;
import com.pwx.ssmdemo.enums.AppointStateEnum;

/**
 * Created by peng on 2018/5/3.
 */
public class AppointExecution {

    /**
     * 图书ID
     */
    private long bookId;

    /**
     * 秒杀预约结果状态
     */
    private int state;

    /**
     * 状态标识
     */
    private String stateInfo;

    /**
     * 预约成功对象
     */
    private Appointment appointment;

    /**
     * 默认构造器
     */
    public AppointExecution() {
    }

    /**
     * 预约失败的构造器
     * @param bookId
     * @param stateEnum
     */
    public AppointExecution(long bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 预约成功的构造器
     * @param bookId
     * @param stateEnum
     * @param appointment
     */
    public AppointExecution(long bookId, AppointStateEnum stateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
