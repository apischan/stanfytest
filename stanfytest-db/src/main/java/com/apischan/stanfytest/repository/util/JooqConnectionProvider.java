package com.apischan.stanfytest.repository.util;

import org.jooq.ConnectionProvider;
import org.jooq.SQLDialect;

public interface JooqConnectionProvider extends ConnectionProvider {

    /**
     * Get sql dialect for particular vendor
     *
     * @return sql dialect
     */
    SQLDialect getSqlDialect();

}
