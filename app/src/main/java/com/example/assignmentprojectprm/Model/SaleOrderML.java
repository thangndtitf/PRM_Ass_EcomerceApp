package com.example.assignmentprojectprm.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class SaleOrderML {
    private int saleOrderID;
    private int custID;
    private int currentStatus;
    private LocalDateTime createdDate;
    private String createdStaffName;
    private int saleStoreID;

    public SaleOrderML(int saleOrderID, int custID, int currentStatus, LocalDateTime createdDate, String createdStaffName, int saleStoreID) {
        this.saleOrderID = saleOrderID;
        this.custID = custID;
        this.currentStatus = currentStatus;
        this.createdDate = createdDate;
        this.createdStaffName = createdStaffName;
        this.saleStoreID = saleStoreID;
    }

    public int getSaleOrderID() {
        return saleOrderID;
    }

    public void setSaleOrderID(int saleOrderID) {
        this.saleOrderID = saleOrderID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(int currentStatus) {
        this.currentStatus = currentStatus;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedStaffName() {
        return createdStaffName;
    }

    public void setCreatedStaffName(String createdStaffName) {
        this.createdStaffName = createdStaffName;
    }

    public int getSaleStoreID() {
        return saleStoreID;
    }

    public void setSaleStoreID(int saleStoreID) {
        this.saleStoreID = saleStoreID;
    }
}
