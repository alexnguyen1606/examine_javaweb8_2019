package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;

import java.util.List;
import java.util.Map;

public interface IBuildingRepository extends JpaRepository<BuildingEntity> {
    List<BuildingEntity> findAll(Map<String,Object> params, Pageable pageable, BuildingSearchBuilder builder);
    List<BuildingEntity> findAll(Map<String,Object> params,Pageable pageable);
    Long save(BuildingEntity buildingEntity);
}
