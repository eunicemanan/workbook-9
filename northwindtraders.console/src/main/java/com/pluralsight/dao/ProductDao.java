package com.pluralsight.dao;

import com.pluralsight.model.Product;
import java.util.List;

public interface ProductDao  {
    List<Product> getAll();
    Product add(Product product);
    List<Product> searchProduct(String searchTerm);

}