package com.example.L07jdbcdemo;


import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {

    public Product getProductById(Integer id){
        Connection connection = null;
        Product product = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "root", "Nab74561$");
            Statement statement = connection.createStatement();
            String sql = "Select * FROM person where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                 product = new Product(resultSet.getInt("id"), resultSet.getString("name"));
            break;
            }

        }catch(SQLException e){
            e.printStackTrace();
            throw  new RuntimeException();

        }finally {
            if (connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return product;
    }

    public List<Product> getAllProducts(){
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "root", "Nab74561$");
            Statement statement = connection.createStatement();
            String sql = "Select * FROM person";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
               Product product = new Product(resultSet.getInt("id"), resultSet.getString("name"));
               products.add(product);
                break;
            }

        }catch(SQLException e){
            e.printStackTrace();
            throw  new RuntimeException();

        }finally {
            if (connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return products;
    }
}
