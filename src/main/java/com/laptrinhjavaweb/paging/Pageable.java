package com.laptrinhjavaweb.paging;

public interface Pageable {
    Integer getPage();
    Integer getOffSet();
    Integer getLimit();
}
