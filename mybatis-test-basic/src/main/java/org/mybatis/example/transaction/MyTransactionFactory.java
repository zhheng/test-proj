package org.mybatis.example.transaction;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/16.
 */
public class MyTransactionFactory implements TransactionFactory {
    public void setProperties(Properties props) {

    }

    public Transaction newTransaction(Connection conn) {
        return null;
    }

    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return null;
    }
}
