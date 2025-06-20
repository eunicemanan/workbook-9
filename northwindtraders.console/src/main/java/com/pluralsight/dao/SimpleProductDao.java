package com.pluralsight.dao;

import com.pluralsight.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> products = new ArrayList<>();
    private int lastProductId = 3;

    public SimpleProductDao() {
        products.add(new Product(1, "Coffee", 6));
        products.add(new Product(2, "Cold Brew", 3));
        products.add(new Product(3, "Smoothie", 7));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product add(Product product) {
        if (product.getProductId() == 0) {
            lastProductId++;
            product.setProductId(lastProductId);
        }
        products.add(product);
        return product;
    }

    // 🔍 Add this method here
    @Override
    public List<Product> searchProduct(String searchTerm) {
        return products.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(searchTerm.toLowerCase()))
                .toList();
    }
}
