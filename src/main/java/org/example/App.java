package org.example;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

import static org.example.data.Config.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
        logger.info("The program has started");
        logger.debug("Flyway migration execute");

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway/scripts")
                .load()
                .migrate();
    }
}
