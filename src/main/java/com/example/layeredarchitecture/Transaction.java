package com.example.layeredarchitecture;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaction {
    Connection connection = DBConnection.getDbConnection().getConnection();

    public Transaction() throws SQLException, ClassNotFoundException {
    }

    public void disableAutoCommit() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void enableAutoCommit() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void rollBack() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }
}
