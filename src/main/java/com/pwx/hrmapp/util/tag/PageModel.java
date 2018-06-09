package com.pwx.hrmapp.util.tag;

import com.pwx.hrmapp.util.common.HrmConstants;

/**
 * 分页实体
 * Created by peng on 2018/6/9.
 */
public class PageModel {

    /**
     * 分页总数据条数
     */
    private int recordCount;

    /**
     * 当前页面
     */
    private int pageIndex;

    /**
     * 每页分多少条数据
     */
    private int pageSize = HrmConstants.PAGE_DEFAULT_SIZE = 4;

    /**
     * 总页数
     */
    private int totalPage;

    public int getRecordCount() {
        return recordCount <= 0 ? 0 : recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageIndex() {
        pageIndex = pageIndex <= 0 ? 1 : pageIndex;
        //判断当前页面是否超过了总页数:如果超过了，默认给最后一页作为当前页
        pageIndex = pageSize >= totalPage ? getTotalPage() : pageIndex;
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        pageSize = pageSize <= HrmConstants.PAGE_DEFAULT_SIZE ? HrmConstants.PAGE_DEFAULT_SIZE : pageSize;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        if (getRecordCount() <= 0) {
            totalPage = 0;
        } else {
            totalPage = (int)Math.ceil((double)getRecordCount() / getPageSize());
        }
        return totalPage;
    }

    public int getFirstLimitParam(){
        return (getPageIndex()-1) * getPageSize();
    }
}
