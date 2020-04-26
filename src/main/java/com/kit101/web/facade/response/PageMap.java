package com.kit101.web.facade.response;

import java.io.Serializable;
import java.util.List;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-05-24
 */
public class PageMap<T> implements Serializable {

    private Integer currentPage;
    private Integer pageSize;
    private Long total;
    private Integer totalPages;
    private List<T> list;

    private PageMap(Integer currentPage, Integer pageSize, Long total, Integer totalPages, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPages = totalPages;
        this.list = list;
    }

    public static <T> PageMap build(Integer currentPage, Integer pageSize, Long total, Integer totalPages, List<T> list) {
        return new PageMap<>(currentPage, pageSize, total, totalPages, list);
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
