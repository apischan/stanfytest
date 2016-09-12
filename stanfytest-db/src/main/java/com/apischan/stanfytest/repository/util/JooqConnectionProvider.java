package com.apischan.stanfytest.repository.util;

import org.jooq.ConnectionProvider;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;

public interface JooqConnectionProvider extends ConnectionProvider {

    /**
     * Get sql dialect for particular vendor
     *
     * @return sql dialect
     */
    SQLDialect getSqlDialect();

    /**
     * Get sql query settings
     *
     * @return settings for sql query
     */
    default Settings getSettings() {
        return new Settings()
                .withRenderNameStyle(RenderNameStyle.AS_IS);
    }

}
