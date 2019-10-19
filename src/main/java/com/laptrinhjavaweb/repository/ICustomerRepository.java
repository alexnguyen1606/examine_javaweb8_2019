package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.paging.Pageable;

import java.util.List;
import java.util.Map;

public interface ICustomerRepository extends JpaRepository<CustomerEntity> {


    List<CustomerEntity> findAll(Map<String,Object> params, Pageable pageable, CustomerSearchBuilder builder);
}
