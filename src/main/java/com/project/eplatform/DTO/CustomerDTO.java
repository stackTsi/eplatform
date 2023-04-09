package com.project.eplatform.DTO;

public class CustomerDTO {
    private int CustomerID;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String streetNum;
    private String streetName;
    private String city;
    private String postalCode;
    private String phoneNumber;
    public CustomerDTO(){

    }
    public CustomerDTO(int customerID, String userName, String password, String fullName, String email, String streetNum, String streetName, String city, String postalCode, String phoneNumber) {
        CustomerID = customerID;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
