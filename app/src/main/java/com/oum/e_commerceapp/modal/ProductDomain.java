package com.oum.e_commerceapp.modal;

/**
 * Created by User on 3/15/2018.
 */

public class ProductDomain {

    String productName;
    int productImageId;
    String productPrice;

    public ProductDomain(){

    }

    public ProductDomain(String productName,int productImageId,String productPrice ) {

        this.productName = productName;
        this. productImageId = productImageId;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getImageId() {
        return productImageId;
    }

    public void setImageId(int productImageimageId) {
        this.productImageId = productImageimageId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
