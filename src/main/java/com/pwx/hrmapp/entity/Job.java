package com.pwx.hrmapp.entity;

import java.io.Serializable;

/**
 * Created by peng on 2018/5/7.
 */
public class Job implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 职位名称
     */
    private String name;

    /**
     * 详细描述
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
