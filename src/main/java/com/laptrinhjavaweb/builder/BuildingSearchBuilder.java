package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {
    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.district = builder.district;
        this.buildingArea = builder.buildingArea;
        this.numberOfBasement = builder.numberOfBasement;
        this.rentAreaFrom = builder.rentAreaFrom;
        this.rentAreaFrom = builder.rentAreaTo;
        this.street = builder.street;
        this.ward = builder.ward;
        this.costRentForm = builder.costRentForm;
        this.costRentTo = builder.costRentTo;
        this.buildingTypes = builder.buildingTypes;
        this.type = builder.type;
        this.staffId = builder.staffId;
    }
    private String name;
    private String district;
    private String street;
    private String ward;
    private String buildingArea;
    private String numberOfBasement;
    private String rentAreaFrom;
    private String rentAreaTo;
    private String costRentForm;
    private String costRentTo;
    private String type ;
    private String[] buildingTypes = new String[]{};
    private String staffId;

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getWard() {
        return ward;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getRentAreaFrom() {
        return rentAreaFrom;
    }

    public String getRentAreaTo() {
        return rentAreaTo;
    }

    public String getCostRentForm() {
        return costRentForm;
    }

    public String getCostRentTo() {
        return costRentTo;
    }

    public String getType() {
        return type;
    }

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public String getStaffId() {
        return staffId;
    }

    public static class Builder{
        private String name;
        private String district;
        private String street;
        private String ward;
        private String buildingArea;
        private String numberOfBasement;
        private String rentAreaFrom;
        private String rentAreaTo;
        private String costRentForm;
        private String costRentTo;
        private String type ;
        private String[] buildingTypes = new String[]{};
        private String staffId;
     public BuildingSearchBuilder build(){
        return new BuildingSearchBuilder(this);
    }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setBuildingArea(String buildingArea) {
            this.buildingArea = buildingArea;
            return this;
        }

        public Builder setNumberOfBasement(String numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setRentAreaFrom(String rentAreaFrom) {
            this.rentAreaFrom = rentAreaFrom;
            return  this;
        }

        public Builder setRentAreaTo(String rentAreaTo) {
            this.rentAreaTo = rentAreaTo;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setCostRentForm(String costRentForm) {
            this.costRentForm = costRentForm;
            return this;
        }

        public Builder setCostRentTo(String costRentTo) {
            this.costRentTo = costRentTo;
            return this;
        }

        public Builder setBuildingTypes(String[] buildingTypes) {
            this.buildingTypes = buildingTypes;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this ;
        }

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }
    }
}
