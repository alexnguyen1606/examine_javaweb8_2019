package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.modelmapper.ModelMapper;

public class BuildingConverter {
    public BuildingDTO covertToDTO(BuildingEntity buildingEntity){
        ModelMapper modelMapper = new ModelMapper();
        BuildingDTO dto= modelMapper.map(buildingEntity,BuildingDTO.class);
        return dto;
    }
    public BuildingEntity covertToEntity(BuildingDTO buildingEntity){
        ModelMapper modelMapper = new ModelMapper();
        BuildingEntity dto= modelMapper.map(buildingEntity,BuildingEntity.class);
        return dto;
    }
}
