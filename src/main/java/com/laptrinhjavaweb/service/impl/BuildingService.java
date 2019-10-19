package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.IBuildingService;

import java.util.List;

public class BuildingService implements IBuildingService {
    @Override
    public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
        return null;
    }

    @Override
    public List<BuildingDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<BuildingDTO> findAll() {
        return null;
    }

    @Override
    public BuildingDTO save(BuildingDTO buildingDTO) {
        return null;
    }

    @Override
    public BuildingDTO findOne(Long id) {
        return null;
    }

    @Override
    public BuildingDTO update(BuildingDTO buildingDTO) {
        return null;
    }

    @Override
    public List<BuildingDTO> delete(Long[] ids) {
        return null;
    }
}
