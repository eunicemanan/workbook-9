package com.pluralsight.controller;

import com.pluralsight.dao.ProductDao;
import com.pluralsight.model.Product; // Assuming this is your model class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("jdbcProductDao")
    private ProductDao productDao;

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }
}

