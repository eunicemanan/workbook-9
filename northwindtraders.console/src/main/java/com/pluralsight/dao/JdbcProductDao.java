package com.pluralsight.dao;


import com.pluralsight.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcProductDao implements ProductDao {

    private DataSource dataSource;
    // Accepting data source
    // Creates a spring instance and injects it into the data source
    @Autowired
    public JdbcProductDao (DataSource dataSource) {

        // the dataSource is injected from the Configuration class
        this.dataSource = dataSource;
    }
    public List<Product> getAll() {
        // SQL query to retrieve product data
        String sql = """
        SELECT productid, productname, unitprice
        FROM products;
        """;


        List<Product> products = new ArrayList<>();


        try (
                // Connect to the database
                Connection connection = dataSource.getConnection();
                // Prepare the SQL statement
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                // Execute the query and get results
                ResultSet resultSet = preparedStatement.executeQuery()) {


            // Loop through the result set and print each product
            while (resultSet.next()) {
                int productId = resultSet.getInt("productid");
                String productName = resultSet.getString("productname");
                double unitPrice = resultSet.getDouble("unitprice");
                Product product = new Product(productId, productName, unitPrice);
                products.add(product);

            }
        } catch (SQLException e) {
            System.out.println("Error retrieving products.");
            e.printStackTrace(); // Developer-friendly error

        }
        return products;

    }

    public  List<Product> searchProduct(String searchTerm) {
        String sql = """
                SELECT *
                FROM products
                WHERE productname LIKE ?;
                """;

        List<Product> products = new ArrayList<>();

            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ) {
                // Add wildcards to allow partial matching (e.g., "%apple%")
                preparedStatement.setString(1, "%" + searchTerm + "%");

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int productID = resultSet.getInt("ProductID");
                        String productName = resultSet.getString("ProductName");
                        double unitPrice = resultSet.getDouble("UnitPrice");

                        Product product = new Product(productID, productName, unitPrice);
                        products.add(product);
                    }
                }

            } catch (SQLException e) {
                System.out.println("There was an error retrieving the products. Please try again, or contact support.");
                e.printStackTrace(); // developer-friendly message
            }

        return products;
    }

    @Override
    public Product add(Product product) {
        String sql = """
        INSERT INTO products (productname, unitprice)
        VALUES (?, ?)
    """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getUnitPrice());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    product.setProductId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

}