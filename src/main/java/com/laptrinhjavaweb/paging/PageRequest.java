package com.laptrinhjavaweb.paging;

public class PageRequest implements Pageable {
    private Integer page;
    private Integer limit;
    private Integer offSet;

    public PageRequest(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    @Override
    public Integer getPage() {
        return this.page;
    }

    @Override
    public Integer getOffSet() {
        return (this.page-1)*this.limit;
    }

    @Override
    public Integer getLimit() {
        return this.limit;
    }
}
