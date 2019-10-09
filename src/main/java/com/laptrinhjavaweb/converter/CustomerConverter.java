package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import org.modelmapper.ModelMapper;

public class CustomerConverter {
    public CustomerDTO convertToDTO(CustomerEntity entity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity,CustomerDTO.class);
    }
    public CustomerEntity convertToEntity(CustomerDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto,CustomerEntity.class);
    }
}
