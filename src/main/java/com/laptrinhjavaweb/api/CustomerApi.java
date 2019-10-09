package com.laptrinhjavaweb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.impl.CustomerService;
import com.laptrinhjavaweb.utils.FormUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/api/customer")
public class CustomerApi extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        CustomerDTO customerDTO = FormUtil.toModel(CustomerDTO.class,request);
        ICustomerService customerService = new CustomerService();
        Pageable pageable = new PageRequest(customerDTO.getPage(),customerDTO.getLimit());
        CustomerSearchBuilder customerSearchBuilder = new CustomerSearchBuilder.Builder()
                .setEmail(customerDTO.getEmail())
                .setFullName(customerDTO.getFullName())
                .setPhoneNumber(customerDTO.getPhoneNumber())
                .setUserId(customerDTO.getUserId())
                .build();
        List<CustomerDTO> customerDTOS = customerService.findAll(customerSearchBuilder,pageable);
        objectMapper.writeValue(response.getOutputStream(),customerDTOS);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
