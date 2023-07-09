package com.example.assignmentprojectprm.Model;

public class User {
    private int customerID;
    private String userName;
    private String userPassword;
    private String customerFullName;
    private String cusCountry;
    private String cusProvince;
    private String cusDistrict;
    private String cusWard;
    private String cusAddress;
    private String cusFullAddress;
    private String cusPhone;
    private String userEmail;

    public User(int customerID, String userName,
                String userPassword, String customerFullName,
                String cusCountry, String cusProvince,
                String cusDistrict, String cusWard,
                String cusAddress, String cusFullAddress,
                String cusPhone, String userEmail)
    {
        this.customerID = customerID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.customerFullName = customerFullName;
        this.cusCountry = cusCountry;
        this.cusProvince = cusProvince;
        this.cusDistrict = cusDistrict;
        this.cusWard = cusWard;
        this.cusAddress = cusAddress;
        this.cusFullAddress = cusFullAddress;
        this.cusPhone = cusPhone;
        this.userEmail = userEmail;
    }

    public User() {

    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCusCountry() {
        return cusCountry;
    }

    public void setCusCountry(String cusCountry) {
        this.cusCountry = cusCountry;
    }

    public String getCusProvince() {
        return cusProvince;
    }

    public void setCusProvince(String cusProvince) {
        this.cusProvince = cusProvince;
    }

    public String getCusDistrict() {
        return cusDistrict;
    }

    public void setCusDistrict(String cusDistrict) {
        this.cusDistrict = cusDistrict;
    }

    public String getCusWard() {
        return cusWard;
    }

    public void setCusWard(String cusWard) {
        this.cusWard = cusWard;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusFullAddress() {
        return cusFullAddress;
    }

    public void setCusFullAddress(String cusFullAddress) {
        this.cusFullAddress = cusFullAddress;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
