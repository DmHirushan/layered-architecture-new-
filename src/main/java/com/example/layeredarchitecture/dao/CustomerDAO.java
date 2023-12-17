package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
     boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
     void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;
     void deleteCustomer(String id) throws SQLException, ClassNotFoundException ;
     String genarateId() throws SQLException, ClassNotFoundException ;
     List <CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException;
}
