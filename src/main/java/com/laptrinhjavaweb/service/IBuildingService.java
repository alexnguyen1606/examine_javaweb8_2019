package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageable;

import java.util.List;

public interface IBuildingService {
    List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable);
    List<BuildingDTO> findAll(Pageable pageable);
    List<BuildingDTO> findAll();
    BuildingDTO save(BuildingDTO buildingDTO);
    BuildingDTO findOne(Long id);
    BuildingDTO update(BuildingDTO buildingDTO);
    List<BuildingDTO> delete(Long[] ids);
}
