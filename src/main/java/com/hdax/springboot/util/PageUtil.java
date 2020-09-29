package com.hdax.springboot.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
    //-- 当前页码
    private Integer currentPage = 1;
    //-- 每页显示数量
    private Integer pageSize = 2;
    //-- 总条数
    private Integer sumCount;
    //-- 总页数
    private Integer sumPage;
    //-- 起始位置
    private Integer start;
    //-- 上一页
    private Integer provPage;
    //-- 下一页
    private Integer nextPage;
    //-- 结果集
    List<T> list = new ArrayList<>();

    public Integer getProvPage() {
        if(currentPage == 1){
            provPage = 1;
        }else{
            provPage = currentPage - 1;
        }
        return provPage;
    }

    public Integer getNextPage() {
        if(currentPage == sumPage){
            nextPage = sumPage;
        }else{
            nextPage = currentPage + 1;
        }
        return nextPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getStart() {
        start = (currentPage - 1) * pageSize;
        return start;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        sumPage = sumCount % pageSize == 0 ? sumCount / pageSize  :sumCount / pageSize + 1 ;
        this.sumCount = sumCount;
    }

    public Integer getSumPage() {
        return sumPage;
    }

    public void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", sumCount=" + sumCount +
                ", sumPage=" + sumPage +
                ", start=" + start +
                ", list=" + list +
                '}';
    }
}
