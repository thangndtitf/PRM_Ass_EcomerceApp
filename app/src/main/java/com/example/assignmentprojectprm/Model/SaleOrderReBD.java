package com.example.assignmentprojectprm.Model;

import java.util.List;

//public SaleOrderML saleOrderML { get; set; }
//public List<SaleOrderDetailML> listSODetail { get; set; }
public class SaleOrderReBD {
    private SaleOrderML saleOrderML;
    private List<SaleOrderDetailML> listSODetail;

    public SaleOrderReBD(SaleOrderML saleOrderML, List<SaleOrderDetailML> listSODetail) {
        this.saleOrderML = saleOrderML;
        this.listSODetail = listSODetail;
    }

    public SaleOrderML getSaleOrderML() {
        return saleOrderML;
    }

    public void setSaleOrderML(SaleOrderML saleOrderML) {
        this.saleOrderML = saleOrderML;
    }

    public List<SaleOrderDetailML> getListSODetail() {
        return listSODetail;
    }

    public void setListSODetail(List<SaleOrderDetailML> listSODetail) {
        this.listSODetail = listSODetail;
    }
}
