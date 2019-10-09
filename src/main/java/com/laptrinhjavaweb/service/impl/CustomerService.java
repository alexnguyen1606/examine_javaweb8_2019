package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.ICustomerRepository;
import com.laptrinhjavaweb.repository.impl.CustomerRepository;
import com.laptrinhjavaweb.service.ICustomerService;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerService implements ICustomerService {
    private CustomerConverter customerConverter ;
    private ICustomerRepository customerRepository;

    public CustomerService() {
        customerConverter = new CustomerConverter();
        customerRepository = new CustomerRepository();
    }

    @Override
    public List<CustomerDTO> findAll(Pageable pageable) {

        return customerRepository.findAll(pageable)
                .stream().map(item-> customerConverter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll()
                .stream().map(item-> customerConverter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findAll(CustomerSearchBuilder fieldSearch, Pageable pageable) {
        Map<String,Object> properties = mapToProperties(fieldSearch);
        return customerRepository.findAll(properties,pageable,fieldSearch)
                .stream().map(item-> customerConverter.convertToDTO(item)).collect(Collectors.toList());
    }
    public Map<String,Object> mapToProperties(CustomerSearchBuilder fieldSearch){
        Map<String,Object> properties = new HashMap<>();
        Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
        try {
        for (Field field : fields){
            if (!field.getName().equals("userId")){
                field.setAccessible(true);
                properties.put(field.getName().toLowerCase(),field.get(fieldSearch));
            }

        }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
