package com.hwua.entity;

import java.util.List;

public class PageEntity {
    private int pageNo;  // 当前页
    private int nextPage; // 下一页
    private int prePage;  // 上一页
    private int pageSize; // 当前页面的记录数
    private Long totalRecords;  // 总记录数
    private int totalPage;  // 总页数
    private List<Message> msgList = null;


    public PageEntity(){

    }


    public PageEntity(int pageNo, int nextPage, int prePage, int pageSize, Long totalRecords, int totalPage, List<Message> msgList) {
        this.pageNo = pageNo;
        this.nextPage = nextPage;
        this.prePage = prePage;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        this.totalPage = totalPage;
        this.msgList = msgList;
    }


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    // 获取后一页的页码
    public int getNextPage() {
        if(pageNo >= getTotalPage()) {
            nextPage = getTotalPage();
        } else {
            nextPage = pageNo + 1;
        }

        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    // 获取前一页
    public int getPrePage() {
        if(pageNo <= 1) {
            prePage = 1;
        } else {
            prePage = pageNo - 1;
        }

        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        totalPage = (int) (totalRecords / pageSize);
        if(totalRecords % pageSize != 0) {
            totalPage = totalPage + 1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Message> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Message> msgList) {
        this.msgList = msgList;
    }
}
