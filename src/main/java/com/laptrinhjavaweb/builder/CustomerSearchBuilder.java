package com.laptrinhjavaweb.builder;

public class CustomerSearchBuilder {
   private String fullName;
   private String phoneNumber;
   private String email;
   private String userId;


    private CustomerSearchBuilder(Builder builder) {
        this.fullName = builder.fullName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.userId = builder.userId;

    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }
 public static   class Builder{
        private String fullName;
        private String phoneNumber;
        private String email;
        private String userId;


        public Builder() {
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }



        public CustomerSearchBuilder build(){
            return new CustomerSearchBuilder(this);
        }
    }
}
