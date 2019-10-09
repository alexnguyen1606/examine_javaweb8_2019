package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.paging.Pageable;

import java.util.List;

public interface JpaRepository<T> {
    List<T> findAll();
    List<T> findAll(Pageable pageable,Object... objects);
    List<T> findAll(String sql,Pageable pageable,Object... objects);
}
