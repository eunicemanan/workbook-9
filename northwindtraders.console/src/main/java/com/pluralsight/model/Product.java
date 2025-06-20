package com.pluralsight.model;

public class Product {
    private int productId;
   private String productName;
   private double unitPrice;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.productName = name;

      this.unitPrice = price;
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

    public int getProductId() {
        return productId;
    }

   public void setProductId(int productId) {
        this.productId = productId;
   }
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

   @Override
   public String toString() {
          final StringBuilder sb = new StringBuilder("Product{");
           sb.append("productId=").append(productId);
           sb.append(", productName='").append(productName).append('\'');
           sb.append(", unitPrice=").append(unitPrice);
           sb.append('}');
           return sb.toString();
   }
}
