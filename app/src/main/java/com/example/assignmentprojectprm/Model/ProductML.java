package com.example.assignmentprojectprm.Model;

import java.io.Serializable;
import java.math.BigDecimal;

//public int productID { get; set; }
//public int productTypeID { get; set; }
//public int currentInstock { get; set; }
//public String productName { get; set; }
//public String description { get; set; }
//public decimal price { get; set; }
public class ProductML implements Serializable {
    private int productID;
    private int productTypeID;
    private String description;
    private String productName;
    private BigDecimal price;
    private int currentInstock;

    public ProductML(int productID, int productTypeID, String description, String productName, BigDecimal price, int currentInstock) {
        this.productID = productID;
        this.productTypeID = productTypeID;
        this.description = description;
        this.productName = productName;
        this.price = price;
        this.currentInstock = currentInstock;
    }

    public ProductML() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(int productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCurrentInstock() {
        return currentInstock;
    }

    public void setCurrentInstock(int currentInstock) {
        this.currentInstock = currentInstock;
    }
}
