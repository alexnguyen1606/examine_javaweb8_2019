package com.laptrinhjavaweb.dto;

public class BuildingDTO extends BaseDTO {
    private String name;

    private String street;//đường

    private String ward;//

    private String district;//quận

    //	private Integer numberOfBasement;
    private String numberOfBasement;
//	private Integer buildingArea;//diện tích sàn

    private String buildingArea;

    private String structure;//cấu trúc tòa nhà

    //private String direction;//hướng

    private Integer costRent;

    private String costRentFrom;

    private String costRentTo;

    private String costDescription;

    private String serviceCost;

    private String carCost;

    private String motorBikeCost;

    private String overTimeCost;

    private String electriCityCost;

    private String payment;

    private String deposit;

    private String timeRent;

    private String timeDecorator;

    private String managerName;

    private String managerPhone;

    private String type;

    private int rentArea;
    private String rentAreaFrom;
    private String rentAreaTo;
    private String staffId;
    private String[] buildingTypes = new String[]{};

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }

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

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getCostRent() {
        return costRent;
    }

    public void setCostRent(Integer costRent) {
        this.costRent = costRent;
    }

    public String getCostRentFrom() {
        return costRentFrom;
    }

    public void setCostRentFrom(String costRentFrom) {
        this.costRentFrom = costRentFrom;
    }

    public String getCostRentTo() {
        return costRentTo;
    }

    public void setCostRentTo(String costRentTo) {
        this.costRentTo = costRentTo;
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

    public int getRentArea() {
        return rentArea;
    }

    public void setRentArea(int rentArea) {
        this.rentArea = rentArea;
    }

    public String getRentAreaFrom() {
        return rentAreaFrom;
    }

    public void setRentAreaFrom(String rentAreaFrom) {
        this.rentAreaFrom = rentAreaFrom;
    }

    public String getRentAreaTo() {
        return rentAreaTo;
    }

    public void setRentAreaTo(String rentAreaTo) {
        this.rentAreaTo = rentAreaTo;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
