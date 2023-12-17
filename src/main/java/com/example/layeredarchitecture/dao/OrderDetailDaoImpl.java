package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.Sql;
import com.example.layeredarchitecture.db.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class OrderDetailDaoImpl implements OrderDetailDao{
    @Override
    public boolean saveOrderDetail(String orderId, String itemCode, BigDecimal unitPrice, int qty) throws SQLException, ClassNotFoundException {

        return new Sql().execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", orderId, itemCode, unitPrice, qty);

    }
}
