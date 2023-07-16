package com.example.assignmentprojectprm.Model;

import java.io.Serializable;

public class productTypeML implements Serializable {
    String imageUrl;
    String productTypeName;
    String description;
    int productTypeID;



    public productTypeML(String imageUrl, String productTypeName, String description, int productTypeID) {
        this.imageUrl = imageUrl;
        this.productTypeName = productTypeName;
        this.description = description;
        this.productTypeID = productTypeID;
    }

    public productTypeML() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(int productTypeID) {
        this.productTypeID = productTypeID;
    }
}
