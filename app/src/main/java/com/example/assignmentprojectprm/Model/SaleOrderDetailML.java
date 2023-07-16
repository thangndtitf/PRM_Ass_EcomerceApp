package com.example.assignmentprojectprm.Model;

import java.math.BigDecimal;
import java.util.Date;

//public int saleOrderDetailID { get; set; }
//public int saleOrderID { get; set; }
//public int productID { get; set; }
//public int quantity { get; set; }
//public decimal totalPrice { get; set; }
//public decimal productPrice { get; set; }
//public decimal discountPrice { get; set; }
public class SaleOrderDetailML {
    private int saleOrderDetailID;
    private int saleOrderID;
    private int productID;
    private int quantity;
    private BigDecimal totalPrice;
    private BigDecimal productPrice;
    private BigDecimal discountPrice;

    public SaleOrderDetailML(int saleOrderDetailID, int saleOrderID, int productID, int quantity, BigDecimal totalPrice, BigDecimal productPrice, BigDecimal discountPrice) {
        this.saleOrderDetailID = saleOrderDetailID;
        this.saleOrderID = saleOrderID;
        this.productID = productID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productPrice = productPrice;
        this.discountPrice = discountPrice;
    }

    public int getSaleOrderDetailID() {
        return saleOrderDetailID;
    }

    public void setSaleOrderDetailID(int saleOrderDetailID) {
        this.saleOrderDetailID = saleOrderDetailID;
    }

    public int getSaleOrderID() {
        return saleOrderID;
    }

    public void setSaleOrderID(int saleOrderID) {
        this.saleOrderID = saleOrderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
}
