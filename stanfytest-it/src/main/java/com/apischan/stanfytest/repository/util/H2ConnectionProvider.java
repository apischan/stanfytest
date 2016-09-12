package com.apischan.stanfytest.repository.util;

import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionProvider implements JooqConnectionProvider {

    @Override
    public Connection acquire() throws DataAccessException {
        try {
            return DriverManager.getConnection("jdbc:h2:mem:jobsdb", "SA", "");
        } catch (SQLException e) {
            throw new DataAccessException("Cannot acquire test connection.");
        }
    }

    @Override
    public void release(Connection connection) throws DataAccessException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("Cannot close test connection.");
        }
    }

    @Override
    public SQLDialect getSqlDialect() {
        return SQLDialect.H2;
    }
}
