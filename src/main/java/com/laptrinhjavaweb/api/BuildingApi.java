package com.laptrinhjavaweb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.HttpUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/api/building"})
public class BuildingApi extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response)throws SecurityException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingDTO buildingDTO = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
        IBuildingService buildingService = new BuildingService();
        objectMapper.writeValue(response.getOutputStream(),buildingService.save(buildingDTO));
    }
    protected void doPut (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingDTO buildingDTO = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
        IBuildingService buildingService = new BuildingService();
        objectMapper.writeValue(response.getOutputStream(),buildingService.update(buildingDTO));
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingDTO buildingDTO = FormUtil.toModel(BuildingDTO.class,request);

        IBuildingService buildingService = new BuildingService();
        BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
                .setName(buildingDTO.getName())
                .setDistrict(buildingDTO.getDistrict())
                .setBuildingArea(buildingDTO.getBuildingArea())
                .setNumberOfBasement(buildingDTO.getNumberOfBasement())
                .setBuildingTypes(buildingDTO.getBuildingTypes())
                //.setType(buildingDTO.getType())
                .setCostRentForm(buildingDTO.getCostRentFrom())
                .setCostRentTo(buildingDTO.getCostRentTo())
                .setRentAreaFrom(buildingDTO.getRentAreaFrom())
                .setRentAreaTo(buildingDTO.getRentAreaTo())
                .setStaffId(buildingDTO.getStaffId())
                .build();
        Pageable pageable = new PageRequest(buildingDTO.getPage(),buildingDTO.getLimit());
        List<BuildingDTO> buildingDTOs = buildingService.findAll(builder,pageable);
        objectMapper.writeValue(response.getOutputStream(),buildingDTOs);
    }
    protected void doDelete (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingDTO buildingDTO = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
        IBuildingService buildingService = new BuildingService();
        objectMapper.writeValue(response.getOutputStream(),buildingService.delete(buildingDTO.getIdDelete()));
    }


}
