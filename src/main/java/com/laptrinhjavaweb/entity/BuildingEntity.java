package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;

@Entity
@Table(name = "building")
public class BuildingEntity  extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;//đường
    @Column(name = "ward")
    private String ward;//
    @Column(name = "district")
    private String district;//quận
    @Column(name = "numberofbasement")
    private Integer numberOfBasement;
    @Column(name = "structure")
    private String structure;//cấu trúc tòa nhà
    //  @Column(name = "direction")
//    private String direction;//hướng
//    @Column(name = "areaforlease")
//    private String areaForLease; //diện tích cho thuê
//    @Column(name = "rank")
//    private String rank;//hạng
    @Column(name = "buildingarea")
    private Integer buildingArea;//diện tích sàn
    @Column(name = "costrent")
    private Integer costRent;
    @Column(name = "costdescription")
    private String costDescription;
    @Column(name = "servicecost")
    private String serviceCost;
    @Column(name = "carcost")
    private String carCost;
    @Column(name = "motorbikecost")
    private String motorBikeCost;
    @Column(name = "overtimecost")
    private String overTimeCost;
    @Column(name = "electricitycost")
    private String electriCityCost;
    @Column(name = "payment")
    private String payment;
    @Column(name = "deposit")
    private String deposit;
    @Column(name = "timerent")
    private String timeRent;
    @Column(name = "timedecorator")
    private String timeDecorator;
    @Column(name = "managername")
    private String managerName;
    @Column(name = "managerphone")
    private String managerPhone;
    @Column(name = "type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Integer buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Integer getCostRent() {
        return costRent;
    }

    public void setCostRent(Integer costRent) {
        this.costRent = costRent;
    }

    public String getCostDescription() {
        return costDescription;
    }

    public void setCostDescription(String costDescription) {
        this.costDescription = costDescription;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getCarCost() {
        return carCost;
    }

    public void setCarCost(String carCost) {
        this.carCost = carCost;
    }

    public String getMotorBikeCost() {
        return motorBikeCost;
    }

    public void setMotorBikeCost(String motorBikeCost) {
        this.motorBikeCost = motorBikeCost;
    }

    public String getOverTimeCost() {
        return overTimeCost;
    }

    public void setOverTimeCost(String overTimeCost) {
        this.overTimeCost = overTimeCost;
    }

    public String getElectriCityCost() {
        return electriCityCost;
    }

    public void setElectriCityCost(String electriCityCost) {
        this.electriCityCost = electriCityCost;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(String timeRent) {
        this.timeRent = timeRent;
    }

    public String getTimeDecorator() {
        return timeDecorator;
    }

    public void setTimeDecorator(String timeDecorator) {
        this.timeDecorator = timeDecorator;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
