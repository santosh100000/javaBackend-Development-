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

    public Product getProductByIdWithPS(Integer id){
        Connection connection = null;
        Product product = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "root", "Nab74561$");

            String sql = "Select * FROM person where id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
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


    public int createProduct(Product product){
        int rowAffected = 0;
        Connection conn = null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "root", "Nab74561$");

            String query = "INSERT INTO person (id, name, age, address) VALUES (?, ?, 26, 'Sydney')";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
             rowAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return rowAffected;
    }


    public Product createProductGfg(Product product){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "user1", "Pass@123");
            Statement statement = con.createStatement();
            String insertStm = "insert into person values (null,'"+product.getName()+"',26, 'KTM'";
            int affectedRows = statement.executeUpdate(insertStm, Statement.RETURN_GENERATED_KEYS);
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    product.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product;
    }

    public Product createProductWithTxn(Product product){
        Connection con = null;
        boolean autoCommit = false;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "user1", "Pass@123");
            autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            String insertStm = "insert into person values (?, ? ,26, 'KTM'";
            PreparedStatement statement = con.prepareStatement(insertStm, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    product.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try {
                    con.setAutoCommit(autoCommit);
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product;
    }


}
