package com.example.assignmentprojectprm.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.util.Date;

//public int saleOrderDetailID { get; set; }
//public int saleOrderID { get; set; }
//public int productID { get; set; }
//public int quantity { get; set; }
//public decimal totalPrice { get; set; }
//public decimal productPrice { get; set; }
//public decimal discountPrice { get; set; }
public class SaleOrderDetailML implements Parcelable {
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

    protected SaleOrderDetailML(Parcel in) {
        saleOrderDetailID = in.readInt();
        saleOrderID = in.readInt();
        productID = in.readInt();
        quantity = in.readInt();
    }

    public static final Creator<SaleOrderDetailML> CREATOR = new Creator<SaleOrderDetailML>() {
        @Override
        public SaleOrderDetailML createFromParcel(Parcel in) {
            return new SaleOrderDetailML(in);
        }

        @Override
        public SaleOrderDetailML[] newArray(int size) {
            return new SaleOrderDetailML[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(saleOrderDetailID);
        parcel.writeInt(saleOrderID);
        parcel.writeInt(productID);
        parcel.writeInt(quantity);
        parcel.writeString(totalPrice.toString());
        parcel.writeString(productPrice.toString());
        parcel.writeString(discountPrice.toString());
    }
}
//    private BigDecimal totalPrice;
//    private BigDecimal productPrice;
//    private BigDecimal discountPrice