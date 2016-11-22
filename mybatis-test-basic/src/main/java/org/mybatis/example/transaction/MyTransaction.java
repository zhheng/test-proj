package org.mybatis.example.transaction;

import org.apache.ibatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16.
 */
public class MyTransaction implements Transaction {
    public Connection getConnection() throws SQLException {
        return null;
    }

    public void commit() throws SQLException {

    }

    public void rollback() throws SQLException {

    }

    public void close() throws SQLException {

    }

    public Integer getTimeout() throws SQLException {
        return null;
    }
}
