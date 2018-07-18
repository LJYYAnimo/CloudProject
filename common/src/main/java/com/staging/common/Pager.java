package com.staging.common;

import java.util.List;

/**
 * 如果自己实现分页的话用此方法返回 比如需要动态传递参数
 * @param <T>
 */
public class Pager<T> {

    private Integer pageNo;
    private Integer pageSize;

    private List<T> rows;
    private Long total;


    private Long pages;

    private Integer code = 200;
    private String msg = "msg";



    public Pager() {
    }

    public Pager(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPages() {
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getBeginIndex() {
        return (pageNo - 1) * pageSize;
    }

}
