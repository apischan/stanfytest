package com.apischan.stanfytest.repository.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.ConnectionProvider;
import org.jooq.exception.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

public class JooqConnectionProvider implements ConnectionProvider {

    private HikariDataSource ds;

    public JooqConnectionProvider() {
        HikariConfig config = new HikariConfig("stanfytest-db/src/main/resources/hikari.properties");
        ds = new HikariDataSource(config);
    }

    @Override
    public Connection acquire() throws DataAccessException {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new DataAccessException("Failed to acquire connection. ", e);
        }
    }

    @Override
    public void release(Connection connection) throws DataAccessException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("Failed to close connection.", e);
        }
    }
}
