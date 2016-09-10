package com.apischan.stanfytest.repository.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {

    private HikariDataSource ds;

    public ConnectionProvider() {
        HikariConfig config = new HikariConfig("stanfytest-db/src/main/resources/hikari.properties");
        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
