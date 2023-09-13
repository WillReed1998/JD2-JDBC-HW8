package org.example;

import org.apache.log4j.Logger;
import org.example.data.Member;
import org.example.data.OsbbCRUD;
import org.example.data.DataBaseMigration;
import java.io.IOException;
import java.sql.SQLException;

public class App {
        private static final Logger logger = Logger.getLogger(org.example.App.class);


        public static void main( String[] args ) {
            logger.info("The program has started");
            DataBaseMigration.fwMigration();

            try (OsbbCRUD crud = new OsbbCRUD().init()) {
                for (Member member : crud.getMembersWithAutoNotAllowed()) {
                    System.out.println(member);
                }
            } catch (SQLException | IOException e) {
                logger.fatal(e);
            }
        }
    }
