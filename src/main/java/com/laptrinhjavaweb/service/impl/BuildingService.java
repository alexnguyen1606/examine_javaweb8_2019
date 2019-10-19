package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BuildingService implements IBuildingService {
    private BuildingConverter converter;
    private BuildingRepository buildingRepository;

    public BuildingService() {
        this.buildingRepository = new BuildingRepository();
        this.converter = new BuildingConverter();
    }

    @Override
    public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
        return null;
    }

    @Override
    public List<BuildingDTO> findAll(Pageable pageable) {
        return buildingRepository.findAll(pageable).stream()
                .map(item-> converter.covertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<BuildingDTO> findAll() {
        return buildingRepository.findAll().stream()
                .map(item-> converter.covertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public BuildingDTO save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = converter.covertToEntity(buildingDTO);
        buildingEntity.setCreatedBy("abc");
        buildingEntity.setCreatedDate(new Date());
        buildingEntity.setModifiedDate(new Date());
        Long id = buildingRepository.save(buildingEntity);
        return findOne(id);
    }

    @Override
    public BuildingDTO findOne(Long id) {
        if (id==null){
            return new BuildingDTO();
        }else {
            return converter.covertToDTO(buildingRepository.findById(id));
        }
    }

    @Override
    public BuildingDTO update(BuildingDTO buildingDTO) {
        if (buildingDTO.getId() == null){
            return new BuildingDTO();
        }else {
            BuildingEntity buildingEntity = converter.covertToEntity(buildingDTO);
            BuildingEntity buildingEntityInDB = buildingRepository.findById(buildingEntity.getId());

            buildingEntity.setModifiedDate(new Date());
            buildingEntity.setModifiedBy("abc");
            buildingEntity.setCreatedDate(buildingEntityInDB.getCreatedDate());
            buildingEntity.setCreatedBy(buildingEntityInDB.getCreatedBy());

            buildingRepository.update(buildingEntity);

            return findOne(buildingDTO.getId());
        }

    }

    @Override
    public List<BuildingDTO> delete(Long[] ids) {
        return null;
    }
}
