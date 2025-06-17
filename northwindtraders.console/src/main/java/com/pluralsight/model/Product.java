package com.pluralsight.model;

public class Product {
    private int productId;
    private String productName;
    private double unitPrice;

    public Product(int productID, String productName, double unitPrice) {
        this.productId = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public int getProductID() {
        return productId;
    }

    public void setProductID(int productID) {
        this.productId = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

}

//public class Product {
//    private int productId;
//    private String name;
//    private String category;
//    private double price;
//
//    public Product(int productId, String name, String category, double price) {
//        this.productId = productId;
//        this.name = name;
//        this.category = category;
//        this.price = price;
//    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Product{");
//        sb.append("productId=").append(productId);
//        sb.append(", name='").append(name).append('\'');
//        sb.append(", category='").append(category).append('\'');
//        sb.append(", price=").append(price);
//        sb.append('}');
//        return sb.toString();
//    }
//}