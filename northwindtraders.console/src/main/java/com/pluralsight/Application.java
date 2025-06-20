package com.pluralsight;


import com.pluralsight.dao.JdbcProductDao;
import com.pluralsight.dao.ProductDao;
import com.pluralsight.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    @Qualifier("jdbcProductDao")
    ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*  productDao.add(new Product(0,"coke", 3.99, 5));*/

       /* productDao.add(new Product(0,"coke", 3.99));*/

        List<Product> products = productDao.getAll();

        System.out.println(products);

    }
}
