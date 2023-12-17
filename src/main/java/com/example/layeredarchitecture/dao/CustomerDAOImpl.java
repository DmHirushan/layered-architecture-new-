package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.Sql;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    Sql sql = new Sql();
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ResultSet rst = sql.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomer.add(customerDTO);
        }
        return allCustomer;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return sql.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());

    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
      sql.execute("UPDATE Customer SET name=?, address=? WHERE id=?", dto.getName(),dto.getAddress(),dto.getId());
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = sql.execute("SELECT id FROM Customer WHERE id=?", id);
        return resultSet.next();
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        sql.execute("delete from customer where id = ?", id);
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = sql.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public List<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = sql.execute("SELECT * FROM Customer");
        List <CustomerDTO> dtoList = new ArrayList<>();
        while (rst.next()){
            dtoList.add(
                    new CustomerDTO(
                            rst.getString(1)
                    )
            );
        }
        return dtoList;
    }
}
