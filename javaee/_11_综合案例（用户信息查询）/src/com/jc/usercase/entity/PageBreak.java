package com.jc.usercase.entity;

import java.util.List;

/**
 * 分页类
 */
public class PageBreak<E> {
    private int currentPage;//当前页码
    private int itemPerPage;//每页显示条目；
    private int total;//总记录数；
    private int totalPage;//总页数;
    private List<E> items;//数据

    public PageBreak() {
    }

    public PageBreak(int currentPage, int itemPerPage, int total, int totalPage, List<E> items) {
        this.currentPage = currentPage;
        this.itemPerPage = itemPerPage;
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(int itemPerPage) {
        this.itemPerPage = itemPerPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageBreak{" +
                "currentPage=" + currentPage +
                ", itemPerPage=" + itemPerPage +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", items=" + items +
                '}';
    }
}
