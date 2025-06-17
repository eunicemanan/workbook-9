package com.pluralsight;


import com.pluralsight.model.Product;
import com.pluralsight.northwindtraders.console.dao.ProductDao;
//import com.pluralsight.northwindtraders.console.dao.SimpleProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      /*  productDao.add(new Product(0,"coke", 3.99, 5));*/

        List<Product> products = ProductDao.getAll();

        System.out.println(products);

    }
}