package org.example.data;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

import static org.example.data.Config.*;

public class DataBaseMigration {

    private static final Logger logger = Logger.getLogger(DataBaseMigration.class);
    public static void fwMigration(){
        logger.debug("Flyway migration execute");

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:osbb/migration")
                .load()
                .migrate();
    }
}
